package id_authentication.service;

import id_authentication.dto.MemberDTO;
import id_authentication.dto.PlanDTO;
import id_authentication.dto.collection.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;
import id_authentication.dto.response.PlanOnlyDTO;

import java.util.List;

public interface MemberService {
    MemberDTO createMember(MemberCreateDTO memberDTO);
    MemberDTO getMember(Long id);
    MemberDTO updateMember(Long memberId,MemberDTO memberDTO);
    MemberDTOs getAllMembers();
    MemberDTO authenticate(String username, String password);
    void deleteMember(long parseLong);
    List<PlanOnlyDTO> getAllPlansForMember(long memberId);

}
