package id_authentication.controller;

import id_authentication.dto.BadgeDTO;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.MemberShipDTO;
import id_authentication.dto.collection.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.dto.response.BadgeOnlyDTO;
import id_authentication.dto.response.MembershipPlanResponseDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.errorhandler.MemberNotFoundException;
import id_authentication.service.IMembershipService;
import id_authentication.service.MemberService;

import id_authentication.service.implementation.BadgeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private IMembershipService membershipService;

    @Autowired
    MemberService memberService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable String id) {
        MemberDTO memberDTO = memberService.getMember(Long.parseLong(id));
        return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createMember(@RequestBody MemberCreateDTO memberDTO) {
        MemberDTO createdMemberDTO = memberService.createMember(memberDTO);
        return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authentication(@RequestBody MemberDTO memberDTO) {
        try {
            MemberDTO createdMemberDTO = memberService.authenticate(memberDTO.getUserName(), memberDTO.getPassword());
            return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);
        } catch (MemberNotFoundException e) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType(e.getMessage()), HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("{memberId}/badges")
    public ResponseEntity<?> findBadgesForMemberId(@PathVariable long memberId) {
        try {
            List<BadgeOnlyDTO> badgeList = new ArrayList<>();
            badgeList = memberService.getBadgesByMemberId(memberId);
            return ResponseEntity.status(HttpStatus.OK).body(badgeList);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Error Retrieving Badges : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }
}
