package id_authentication.service;

import id_authentication.domain.Member;
import id_authentication.dto.MemberDTO;
import id_authentication.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    public MemberDTO createMember(MemberDTO memberDTO){
        Member member=modelMapper.map(memberDTO, Member.class);
       memberRepository.save(member);
       MemberDTO createdMemberDTO= modelMapper.map(member, MemberDTO.class);
       return createdMemberDTO;
    }
}
