package id_authentication.controller;

import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.service.IMembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("membership")
public class MembershipController {

    private IMembershipService membershipService;
    @PostMapping
    public ResponseEntity<?> createMembership(@RequestBody MembershipRequestDto membershipRequestDto) {
        MembershipResponseDto membershipResponseDto = membershipService.save(membershipRequestDto);
        return new ResponseEntity<>(membershipResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMembership(@PathVariable("id") long id) {
        try{
            MembershipResponseDto membershipResponseDto = membershipService.getMembership(id);
            return new ResponseEntity<>(membershipResponseDto, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMemberships(){
        return new ResponseEntity<>(membershipService.getAllMemberships(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMembership(@PathVariable long id, @RequestBody MembershipRequestDto membershipRequestDto){
        try{
            MembershipResponseDto membershipResponseDto = membershipService.updateMembership(id, membershipRequestDto);
            return new ResponseEntity<>(membershipResponseDto, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMembership(@PathVariable long id) {
        try{
            membershipService.deleteMembership(id);
            return new ResponseEntity<>("", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to remove!!", HttpStatus.NOT_FOUND);
        }
    }
}
