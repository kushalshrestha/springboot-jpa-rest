package id_authentication.service.implementation;

import id_authentication.domain.Badge;
import id_authentication.domain.Member;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.repositories.*;
import id_authentication.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ModelMapper modelMapper;
    public MemberDTO createMember(MemberDTO memberDTO){
        Member member=modelMapper.map(memberDTO, Member.class);
        Member createdMember=memberRepository.save(member);
       //Member createdMember=memberRepository.findMemberByMemberNumber(member.getMemberNumber());
       MemberDTO createdMemberDTO= modelMapper.map(createdMember, MemberDTO.class);
       return createdMemberDTO;
    }

    public MemberDTO getMember(Long id){
        Optional<Member> locationOptional = memberRepository.findById(id);
        if(locationOptional.isPresent()){
            return modelMapper.map(locationOptional.get(), MemberDTO.class);
        }else{
            throw new RuntimeException("Location not found " + id);
        }
    }

    public MemberDTO updateMember(Long memberId,MemberDTO memberDTO){
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if (memberOptional.isPresent()) {
            Member foundMember = memberOptional.get();
            foundMember.setMemberNumber(memberDTO.getMemberNumber());
            foundMember.setFirstName(memberDTO.getFirstName());
            foundMember.setLastName(memberDTO.getLastName());
            foundMember.setUserName(memberDTO.getUserName());
            foundMember.setPassword(memberDTO.getPassword());
            return modelMapper.map(memberRepository.save(foundMember), MemberDTO.class);
        }else {
            throw new RuntimeException("Member not found" + memberId);
        }
    }

    public MemberDTOs getAllMembers() {
        MemberDTOs memberDTOs=new MemberDTOs();
        memberRepository.findAll().forEach(member -> {
            MemberDTO memberDTO=modelMapper.map(member, MemberDTO.class);
            memberDTOs.addMemberDTO(memberDTO);
        });
        return memberDTOs;
    }

    @Transactional
    public void deleteMember(long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isPresent()) {
            memberRepository.deleteById(id);

        } else {
            throw new RuntimeException("Member not found" + id);
        }
    }
}
