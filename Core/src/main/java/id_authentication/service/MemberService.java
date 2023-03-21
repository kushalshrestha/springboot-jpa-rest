package id_authentication.service;

import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.MemberDTOs;

public interface MemberService {
    MemberDTO createMember(MemberDTO memberDTO);
    MemberDTO getMember(Long id);
    MemberDTO updateMember(Long memberId,MemberDTO memberDTO);
    MemberDTOs getAllMembers();
    void deleteMember(long parseLong);
}
