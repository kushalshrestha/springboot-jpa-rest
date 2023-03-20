package id_authentication.controller;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    MemberService memberService;
        @GetMapping("/{id}")
        public ResponseEntity<?> getMember(@PathVariable String id){
            MemberDTO memberDTO=memberService.getMember(Long.parseLong(id));
            return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
        }

        @PostMapping("")
        public ResponseEntity<?> createMember(@RequestBody MemberDTO memberDTO){
            MemberDTO createdMemberDTO=memberService.createMember(memberDTO);
            return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);
        }
        @PutMapping("/{id}")
        public ResponseEntity<?> updateMember(@PathVariable String id,@RequestBody MemberDTO memberDTO){
            MemberDTO updatedMemberDTO=memberService.updateMember(Long.parseLong(id),memberDTO);
            return new ResponseEntity<MemberDTO>(updatedMemberDTO, HttpStatus.OK);
        }

        @GetMapping("")
        public ResponseEntity<?> getAllMembers(){
            MemberDTOs memberDTOs=memberService.getAllMembers();
            return new ResponseEntity<MemberDTOs>(memberDTOs, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteMember(@PathVariable String id){
            memberService.deleteMember(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}
