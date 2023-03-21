package id_authentication.controller;

import id_authentication.domain.Membership;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.service.IMembershipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {
    @Autowired
    private IMembershipService membershipService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> createMembership(@RequestBody MembershipRequestDto membershipRequestDto) {
        try {
            MembershipResponseDto membershipResponseDto = membershipService.save(membershipRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(membershipResponseDto);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Failed to create membership!! Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMembership(@PathVariable("id") long id) {
        try {
            MembershipResponseDto membershipResponseDto = membershipService.getMembership(id);
            if (membershipResponseDto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CustomErrorType("Membership not found with id " + id));
            }
            return ResponseEntity.status(HttpStatus.OK).body(membershipResponseDto);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Error retrieving membership with id " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMemberships() {
        try {
            List<Membership> memberships = membershipService.getAllMemberships();
            if (memberships.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CustomErrorType("No memberships found"));
            }
            List<MembershipResponseDto> membershipResponseDto = memberships
                    .stream()
                    .map(membership -> modelMapper.map(membership, MembershipResponseDto.class))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(membershipResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomErrorType("Error retrieving memberships: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMembership(@PathVariable long id, @RequestBody MembershipRequestDto membershipRequestDto) {
        try {
            MembershipResponseDto membershipResponseDto = membershipService.updateMembership(id, membershipRequestDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(membershipResponseDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorType(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMembership(@PathVariable long id) {
        try {
            membershipService.deleteMembership(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted!!");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorType(e.getMessage()));
        }
    }
}
