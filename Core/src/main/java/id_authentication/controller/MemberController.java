package id_authentication.controller;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.service.implementation.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    MemberServiceImp memberServiceImp;
        @GetMapping("/{id}")
        public ResponseEntity<?> getMember(@PathVariable String id){
            MemberDTO memberDTO= memberServiceImp.getMember(Long.parseLong(id));
            return new ResponseEntity<MemberDTO>(memberDTO, HttpStatus.OK);
        }

        @PostMapping("")
        public ResponseEntity<?> createMember(@RequestBody MemberDTO memberDTO){
            MemberDTO createdMemberDTO= memberServiceImp.createMember(memberDTO);
            return new ResponseEntity<MemberDTO>(createdMemberDTO, HttpStatus.CREATED);
        }
        @PutMapping("/{id}")
        public ResponseEntity<?> updateMember(@PathVariable String id,@RequestBody MemberDTO memberDTO){
            MemberDTO updatedMemberDTO= memberServiceImp.updateMember(Long.parseLong(id),memberDTO);
            return new ResponseEntity<MemberDTO>(updatedMemberDTO, HttpStatus.OK);
        }

        @GetMapping("")
        public ResponseEntity<?> getAllMembers(){
            MemberDTOs memberDTOs= memberServiceImp.getAllMembers();
            return new ResponseEntity<MemberDTOs>(memberDTOs, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteMember(@PathVariable String id){
            memberServiceImp.deleteMember(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}
