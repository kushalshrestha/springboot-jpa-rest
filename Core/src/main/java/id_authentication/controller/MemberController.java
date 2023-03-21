package id_authentication.controller;

import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.service.IMembershipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private IMembershipService membershipService;
    private ModelMapper modelMapper;

    @GetMapping("{memberId}/memberships")
    public ResponseEntity<?> findMembershipsByMemberId(@PathVariable String memberId){
        List<MembershipResponseDto> membershipResponseDto = membershipService.findAllByMemberId(memberId);
        return new ResponseEntity<List<MembershipResponseDto>>(membershipResponseDto, HttpStatus.OK);
    }
}
