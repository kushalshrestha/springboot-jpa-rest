package id_authentication.service;

import id_authentication.domain.Badge;
import id_authentication.domain.Member;
import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BadgeRepository badgeRepository;
    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    CheckInRecordRepository checkInRecordRepository;
    @Autowired
    ModelMapper modelMapper;
    public MemberDTO createMember(MemberDTO memberDTO){
        Member member=modelMapper.map(memberDTO, Member.class);
       memberRepository.save(member);
       Member createdMember=memberRepository.findMemberByMemberNumber(member.getMemberNumber());
       MemberDTO createdMemberDTO= modelMapper.map(createdMember, MemberDTO.class);
       return createdMemberDTO;
    }

    public MemberDTO getMember(Long id){
        Member member=memberRepository.findById(id).get();
        MemberDTO memberDTO=modelMapper.map(member, MemberDTO.class);
//        System.out.println("-----------");
//        System.out.println(memberDTO.getFirstName());
        return memberDTO;
    }

    public MemberDTO updateMember(Long memberId,MemberDTO memberDTO){
        Member member=modelMapper.map(memberDTO, Member.class);
        memberRepository.save(member);
        Member updatedMember=memberRepository.findById(memberId).get();
        MemberDTO updatedMemberDTO=modelMapper.map(updatedMember, MemberDTO.class);
        return updatedMemberDTO;
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
    public void deleteMember(long parseLong) {
        Member member=memberRepository.findByIdEagerFetchBadge(parseLong);
        for(Badge badge:member.getBadges())
        {
            badge.getTransactions().forEach(transaction -> {
            transactionRepository.delete(transaction);
        });
            badgeRepository.delete(badge);
        }

        member=memberRepository.findByIdEagerFetchMembership(parseLong);
        member.getMemberships().forEach(membership -> {
            membershipRepository.delete(membership);
        });

        member=memberRepository.findByIdEagerFetchCheckInRecords(parseLong);
        member.getCheckInRecords().forEach(checkInRecord -> {
            checkInRecordRepository.delete(checkInRecord);
        });

        memberRepository.delete(member);
    }
}
