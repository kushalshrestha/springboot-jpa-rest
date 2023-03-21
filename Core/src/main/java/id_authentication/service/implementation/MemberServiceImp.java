package id_authentication.service.implementation;

import id_authentication.domain.Member;
import id_authentication.domain.Role;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.dto.response.BadgeOnlyDTO;
import id_authentication.errorhandler.MemberNotFoundException;
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
        Role role = roleRepository.findById(memberDTO.getRoleId()).get();
        member.setRole(role);
        //System.out.println(member.getMemberNumber()+"-----------");
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        //System.out.println("_________member.getPassword()__________"+member.getPassword());
        Member createdMember = memberRepository.save(member);
        //Member createdMember=memberRepository.findMemberByMemberNumber(member.getMemberNumber());
        MemberDTO createdMemberDTO = modelMapper.map(createdMember, MemberDTO.class);
        return createdMemberDTO;
    }

    public MemberDTO getMember(Long id) {
        Optional<Member> locationOptional = memberRepository.findById(id);
        if (locationOptional.isPresent()) {
            return modelMapper.map(locationOptional.get(), MemberDTO.class);
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

        Member member = memberRepository.findMemberByUserName(username);
        String encodedPassword = member.getPassword();
        if (passwordEncoder.matches(password, encodedPassword)) {
            return modelMapper.map(member, MemberDTO.class);
        } else {
            throw new MemberNotFoundException("Invalid username or password");
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

}
