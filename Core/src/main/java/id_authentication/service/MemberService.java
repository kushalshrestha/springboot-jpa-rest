package id_authentication.service;

import id_authentication.dto.MemberDTO;
import id_authentication.dto.collection.TransactionDTOs;
import id_authentication.dto.request.MemberCreateDTO;
import id_authentication.dto.collection.MemberDTOs;

import java.util.List;

public interface MemberService {
    MemberDTO createMember(MemberCreateDTO memberDTO);

    MemberDTO getMember(Long id);

    MemberDTO updateMember(Long memberId, MemberDTO memberDTO);

    MemberDTOs getAllMembers();

    MemberDTO authenticate(String username, String password);

    void deleteMember(long parseLong);

    TransactionDTOs findAllTransactionsByMemberId(Long memberId);
}
