package id_authentication.service.implementation;

import id_authentication.domain.Transaction;
import id_authentication.dto.CheckInValidatorDTO;
import id_authentication.dto.ICheckValidatorDTO;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.dto.collection.CheckInValidatorDTOs;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import id_authentication.service.TransactionService;
import org.hibernate.annotations.Check;
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
    private ModelMapper modelMapper;
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


    @Override
    public TransactionStatusDTO addTransaction(long badgeId, long planId, long locationId) {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction;
        if (checkIsAllowed(badgeId, planId, locationId)) {
            transaction = new Transaction(now, TransactionType.ALLOWED.getValue());
        } else {
            transaction = new Transaction(now, TransactionType.DECLINED.getValue());
        }
        Member member = badgeRepository.findById(badgeId).get().getMember();
        Transaction savedTransaction =
                saveTransaction(transaction, badgeId, planId, locationId, member.getId(), member.getRole().getId());
        TransactionStatusDTO transactionStatusDTO = modelMapper.map(savedTransaction, TransactionStatusDTO.class);
        return transactionStatusDTO;
    }

    @Override
    public boolean checkIsAllowed(long badgeId, long planId, long locationId) {
        ICheckValidatorDTO checkValidator = transactionRepository.extractDetails(badgeId, planId, locationId);
        if (checkValidator == null) {
            return false;
        }
        if (checkValidator.getType().equalsIgnoreCase("UNLIMITED")) {
            return true;
        }
        Boolean isInLimit = true;
        List<CheckInRecord> checkInRecord = checkInRecordRepository
                .findCheckInRecordWithMember(checkValidator.getMemberId(), checkValidator.getPlanId());
        if (checkInRecord.size() > 0) {
            int maxAllowedCount = rolePlanLimitRepository.findRolePlanLimitWithRoleAndPlan(checkValidator.getRoleId(), planId)
                    .get(0).getLimitValue();
            int currentCount = checkInRecord.get(0).getCount();
            isInLimit = currentCount < maxAllowedCount;
        }
        return isInLimit;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction, long badgeId, long planId, long locationId, long memberId, long roleId) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        transactionRepository.updateTransactionDetail(badgeId, planId, locationId, savedTransaction.getId());
        List<CheckInRecord> checkInRecord = checkInRecordRepository.findCheckInRecordWithMember(memberId, planId);
        if (checkInRecord.size() > 0) {
            Long id = checkInRecord.get(0).getId();
            checkInRecordRepository.updateCheckInRecordCount(checkInRecord.get(0).getId());
        } else {
            CheckInRecord newCheckInRecord = new CheckInRecord(1, transaction.getDateTime());
            CheckInRecord savedRecord = checkInRecordRepository.save(newCheckInRecord);
            checkInRecordRepository.updateCheckInRecordDetail(savedRecord.getId(), planId, memberId, roleId);
        }
        return savedTransaction;
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
