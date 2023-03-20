package id_authentication.service;

import id_authentication.domain.Membership;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;

import java.util.List;

public interface IMembershipService {
    MembershipResponseDto save(MembershipRequestDto membershipRequestDto);
    MembershipResponseDto getMembership(long id);

    List<Membership> getAllMemberships();

    MembershipResponseDto updateMembership(long id, MembershipRequestDto membershipRequestDto);
    void deleteMembership(long id);

//    List<MembershipResponseDto> findAllByMembershipNumber(String memberNumber);

//    List<MembershipResponseDto> findAll();
}
