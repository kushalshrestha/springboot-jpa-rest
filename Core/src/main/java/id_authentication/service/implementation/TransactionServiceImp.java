package id_authentication.service.implementation;

import id_authentication.domain.Transaction;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import id_authentication.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

//import javax.transaction.Transaction;
import java.util.Optional;
import id_authentication.domain.*;
import id_authentication.dto.response.TransactionStatusDTO;
import id_authentication.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
    @Autowired
     private  ModelMapper modelMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    CheckInRecordRepository checkInRecordRepository;
    @Autowired
    RolePlanLimitRepository rolePlanLimitRepository;

    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()) {
            Transaction foundTran = transactionOptional.get();
            foundTran.setDateTime(transactionDTO.getDateTime());
            foundTran.setTransactionType(transactionDTO.getTransactionType());
            return modelMapper.map(transactionRepository.save(foundTran), TransactionDTO.class);
        } else {
            throw new ResourceNotFoundException("Transaction not found" + id);

        }
    }

    private Boolean isAllowed(LocalDateTime dateTime, long badgeId, long planId, long locationId) {
        LocalTime time = dateTime.toLocalTime();
        Badge badge = badgeRepository.findBadgeByIdAndStatus(badgeId, BadgeStatus.ACTIVE.getValue());
        if (badge == null) {
            return false;
        }

        Member member = badgeRepository.findById(badgeId).get().getMember();

        //check if member has plan
        List<Membership> memberships = member.getMemberships().stream()
                .filter(membership -> membership.getPlan().getId() == planId).collect(Collectors.toList());
        if (memberships.size() > 0) {
            //check if location is open
            Location location = locationRepository.findById(locationId).get();
            List<LocationTimeSlot> locationTimeSlot = location.getTimeSlots().stream()
                    .filter(timeSlot -> timeSlot.getStartTime().isAfter(time) && timeSlot.getEndTime().isBefore(time))
                    .collect(Collectors.toList());
            if (locationTimeSlot.size() > 0) {
                //check if plan is unlimited
                Boolean isUnlimited = memberships.stream().filter(membership -> membership.getType().equalsIgnoreCase(MembershipType.UNLIMITED.getValue())).findFirst().isPresent();
                if (isUnlimited) {
                    return true;
                }

                //check if member has reached limit
                Boolean isInLimit;
                List<CheckInRecord> checkInRecords = checkInRecordRepository.findCheckInRecordWithMember(member.getId(), planId);
                if (checkInRecords.size() > 0) {
                    Integer limit = rolePlanLimitRepository.findRolePlanLimitWithRoleAndPlan(member.getRole().getId(), planId)
                            .stream()
                            .map(rolePlanLimit -> rolePlanLimit.getLimitValue()).max(Integer::compareTo).get();

                    isInLimit = checkInRecords.stream()
                            .filter(checkInRecord -> checkInRecord.getCount() < limit).findFirst().isPresent();
                } else {
                    isInLimit = true;
                }

                if (isInLimit) {
                    if (member.getRole().getName().equalsIgnoreCase(RoleType.FACULTY.getValue())) {
                        return true;
                    }

                    //check if member has checked in within the time slot
                    Boolean isSecondCheckIn = checkInRecords.stream()
                            .filter(checkInRecord -> checkInRecord.getLastCheckIn().toLocalDate().equals(dateTime.toLocalDate())
                                    && checkInRecord.getLastCheckIn().toLocalTime().isAfter(locationTimeSlot.get(0).getStartTime())
                                    && checkInRecord.getLastCheckIn().toLocalTime().isBefore(locationTimeSlot.get(0).getEndTime())
                            )
                            .findFirst().isPresent();
                    if (!isSecondCheckIn) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction, long badgeId, long planId, long locationId, long memberId, long roleId) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        transactionRepository.updateTransactionDetail(badgeId, planId, locationId, savedTransaction.getId());
        List<CheckInRecord> checkInRecords = checkInRecordRepository.findCheckInRecordWithMember(memberId, planId);
        if (checkInRecords.size() > 0) {
            checkInRecordRepository.updateCheckInRecordCount(checkInRecords.get(0).getId());
        } else {
            CheckInRecord checkInRecord = new CheckInRecord(1, transaction.getDateTime());
            CheckInRecord savedRecord = checkInRecordRepository.save(checkInRecord);
            checkInRecordRepository.updateCheckInRecordDetail(savedRecord.getId(), planId, memberId, roleId);
        }
        return savedTransaction;
    }

    @Override
    public TransactionStatusDTO addTransaction(long badgeId, long planId, long locationId) {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction;
        if (true) {//isAllowed(now,badgeId, planId, locationId)
            transaction = new Transaction(now, TransactionType.ALLOWED.getValue());
        } else {
            transaction = new Transaction(now, TransactionType.DECLINED.getValue());
        }
        Member member = badgeRepository.findById(badgeId).get().getMember();
        Transaction savedTransaction =
                saveTransaction(transaction, badgeId, planId, locationId, member.getId(), member.getRole().getId());
        return modelMapper.map(savedTransaction, TransactionStatusDTO.class);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();
        if (transactionList.isEmpty()) {
            throw new ResourceNotFoundException("No transactions found");
        }
        return transactionList
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO getTransaction(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id " + id));
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    @Override
    public String deleteTransaction(long id) {
        Optional<Transaction> transasctionOptional = transactionRepository.findById(id);
        if (transasctionOptional.isPresent()) {
            transactionRepository.deleteById(id);
            return "Transaction deleted";
        } else {
            throw new ResourceNotFoundException("Transaction not found with ID: " + id);
        }
    }
}
