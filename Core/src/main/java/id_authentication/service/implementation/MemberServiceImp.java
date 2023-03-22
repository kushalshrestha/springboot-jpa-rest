package id_authentication.service.implementation;
import id_authentication.domain.Member;
import id_authentication.domain.Role;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.dto.collection.TransactionDTOs;
import id_authentication.dto.request.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.dto.response.MemberDetailDTO;
import id_authentication.dto.response.PlanOnlyDTO;
import id_authentication.exceptions.MemberNotFoundException;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.dto.response.BadgeOnlyDTO;
import id_authentication.repositories.*;
import id_authentication.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ModelMapper modelMapper;

    public MemberDTO createMember(MemberCreateDTO memberDTO) {
        Member member = modelMapper.map(memberDTO, Member.class);
        if(memberDTO.getRoleId() == null ){
            throw new RuntimeException("RoleId required");
        }
        Role role = roleRepository.findById(memberDTO.getRoleId()).get();
        member.setRole(role);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member createdMember = memberRepository.save(member);
        MemberDTO createdMemberDTO = modelMapper.map(createdMember, MemberDTO.class);
        return createdMemberDTO;
    }

    public MemberDetailDTO getMember(Long id) {
        Optional<Member> locationOptional = memberRepository.findById(id);
        if (locationOptional.isPresent()) {
            return modelMapper.map(locationOptional.get(), MemberDetailDTO.class);
        } else {
            throw new RuntimeException("Location not found " + id);
        }
    }

    public MemberDTO updateMember(Long memberId, MemberDTO memberDTO) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if (memberOptional.isPresent()) {
            Member foundMember = memberOptional.get();
            foundMember.setMemberNumber(memberDTO.getMemberNumber());
            foundMember.setFirstName(memberDTO.getFirstName());
            foundMember.setLastName(memberDTO.getLastName());
            foundMember.setUserName(memberDTO.getUserName());
            foundMember.setPassword(memberDTO.getPassword());
            return modelMapper.map(memberRepository.save(foundMember), MemberDTO.class);
        } else {
            throw new RuntimeException("Member not found" + memberId);
        }
    }

    public MemberDTOs getAllMembers() {
        MemberDTOs memberDTOs = new MemberDTOs();
        memberRepository.findAll().forEach(member -> {
            MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
            memberDTOs.addMemberDTO(memberDTO);
        });
        return memberDTOs;
    }

    public MemberDTO authenticate(String username, String password) {
        try{
            Member member= memberRepository.findMemberByUserName(username);
            if(member.getMemberNumber()==null)
            {
                throw new MemberNotFoundException("User Not Found");
            }
            String encodedPassword = member.getPassword();
            if(passwordEncoder.matches(password,encodedPassword ))
            {
                return modelMapper.map(member, MemberDTO.class);
            }
            else
            {
                throw new MemberNotFoundException("Invalid password");
            }
        }
        catch (Exception e){
            throw new MemberNotFoundException("Invalid Username or Password");

        }
    }


    public void deleteMember(long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            memberRepository.deleteById(id);

        } else {
            throw new RuntimeException("Member not found" + id);
        }
    }
    @Override
    public List<PlanOnlyDTO> getAllPlansForMember(long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (!memberOptional.isPresent()) {
            throw new RuntimeException("Member not found" + memberId);
        }
        List<PlanOnlyDTO> planDTOs = memberOptional.get().getMemberships().stream()
                .map(membership -> modelMapper.map(membership.getPlan(), PlanOnlyDTO.class))
                .collect(Collectors.toList());
        return planDTOs;
    }

    public List<BadgeOnlyDTO> getMemberBadgesByMemberId(long memberId, String status) {
        List<BadgeOnlyDTO> badgeList = new ArrayList<BadgeOnlyDTO>();
        if (status != null &&
                (status.toLowerCase().equals("active") || status.toLowerCase().equals("inactive"))
        ) {
            return badgeRepository.findMemberBadgesByStatus(memberId, status).stream()
                    .map(badge -> modelMapper.map(badge, BadgeOnlyDTO.class))
                    .collect(Collectors.toList());
        } else {
            return badgeRepository.findBadgesByMemberId(memberId).stream()
                    .map(badge -> modelMapper.map(badge, BadgeOnlyDTO.class))
                    .collect(Collectors.toList());
        }
    }

    public TransactionDTOs findAllTransactionsByMemberId(Long memberId) {
        TransactionDTOs transactionDTOs = new TransactionDTOs();
        memberRepository.findTransactionsByMemberId(memberId).forEach(transaction -> {
            transactionDTOs.addTransactionDTO(modelMapper.map(transaction, TransactionDTO.class));
        });
        if (transactionDTOs.getTransactions().size() == 0) {
            throw new ResourceNotFoundException("No transactions found for member id " + memberId);
        }
        return transactionDTOs;
    }

    public List<BadgeOnlyDTO> getBadgesByMemberId(long memberId) {
        List<BadgeOnlyDTO> badgeList = new ArrayList<BadgeOnlyDTO>();
        return badgeRepository.findBadgesByMemberId(memberId).stream()
                .map(badge -> modelMapper.map(badge, BadgeOnlyDTO.class))
                .collect(Collectors.toList());
    }

}
