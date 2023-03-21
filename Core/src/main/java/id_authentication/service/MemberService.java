package id_authentication.service;

import id_authentication.dto.MemberDTO;
import id_authentication.dto.MemberShipDTO;
import id_authentication.dto.collection.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;

import java.util.List;

public interface MemberService {
    MemberDTO createMember(MemberCreateDTO memberDTO);
    MemberDTO getMember(Long id);
    MemberDTO updateMember(Long memberId,MemberDTO memberDTO);
    MemberDTOs getAllMembers();
    MemberDTO authenticate(String username, String password);
    void deleteMember(long parseLong);
    List<MemberShipDTO> getMembershipsByMemberId(Long memberId);
}
