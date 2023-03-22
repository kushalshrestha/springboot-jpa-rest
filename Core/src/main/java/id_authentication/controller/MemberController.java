package id_authentication.controller;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.TransactionDTOs;
import id_authentication.dto.request.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.dto.response.BadgeOnlyDTO;
import id_authentication.dto.response.MemberDetailDTO;
import id_authentication.dto.response.MembershipPlanResponseDto;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.PayloadNotValidException;
import id_authentication.service.IMembershipService;
import id_authentication.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    @Autowired
    private IMembershipService membershipService;
    @Autowired
    private MemberService memberService;

//    @Autowired
//    Validator validator;
    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable String id) {
        MemberDetailDTO memberDTO = memberService.getMember(Long.parseLong(id));
        return new ResponseEntity<MemberDetailDTO>(memberDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createMember(@RequestBody MemberCreateDTO memberDTO) {

//            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//            Validator validator = validatorFactory.getValidator();
//
//        Set<ConstraintViolation<MemberCreateDTO>> violations = validator.validate(memberDTO);
//        if (!violations.isEmpty())
//        { List<String> violationMsglist=violations.stream().map(violation -> violation.getMessage()).collect(Collectors.toList());
//            String violationMessage = String.join(",", violationMsglist);
//            throw new PayloadNotValidException(violationMessage);
//        }
        MemberDTO createdMemberDTO = memberService.createMember(memberDTO);
        return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);

    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authentication(@RequestBody MemberDTO memberDTO) {
        MemberDTO createdMemberDTO = memberService.authenticate(memberDTO.getUserName(), memberDTO.getPassword());
        return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable String id, @RequestBody MemberDTO memberDTO) {
        MemberDTO updatedMemberDTO = memberService.updateMember(Long.parseLong(id), memberDTO);
        return new ResponseEntity<MemberDTO>(updatedMemberDTO, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMembers() {
        MemberDTOs memberDTOs = memberService.getAllMembers();
        return new ResponseEntity<MemberDTOs>(memberDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable String id) {
        memberService.deleteMember(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("{memberId}/memberships")
    public ResponseEntity<?> findMembershipsByMemberId(@PathVariable long memberId) {
        try {
            List<MembershipPlanResponseDto> memberShipDTOList = new ArrayList<>();
            memberShipDTOList = membershipService.getMembershipsByMemberId(memberId);
            return ResponseEntity.status(HttpStatus.OK).body(memberShipDTOList);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Error retrieving memberships for memberID " + memberId + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }

    @GetMapping("/{memberId}/plans")
    public ResponseEntity<?>getPlansForMember(@PathVariable Long memberId){
            return new ResponseEntity<>(memberService.getAllPlansForMember(memberId), HttpStatus.OK);
    }

    @GetMapping("/{memberId}/transactions")
    public ResponseEntity<?> findTransactionsByMemberId(@PathVariable String memberId){
        TransactionDTOs transactionDTOS = memberService.findAllTransactionsByMemberId(Long.parseLong(memberId));
        return new ResponseEntity<TransactionDTOs>(transactionDTOS, HttpStatus.OK);
    }


    @GetMapping("{memberId}/badges")
    public ResponseEntity<?> findBadgesForMemberId(@PathVariable long memberId,
                                                   @RequestParam(value="filter", required = false) String filter) {
        try {
            List<BadgeOnlyDTO> badgeList = new ArrayList<>();
            badgeList = memberService.getMemberBadgesByMemberId(memberId, filter);
            return ResponseEntity.status(HttpStatus.OK).body(badgeList);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Error Retrieving Badges : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }
}
