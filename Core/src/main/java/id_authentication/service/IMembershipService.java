package id_authentication.service;
import id_authentication.domain.Membership;
import id_authentication.dto.collection.MembershipPlanResponseDTOs;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IMembershipService {
    MembershipResponseDto save(MembershipRequestDto membershipRequestDto);

    MembershipResponseDto getMembership(long id) throws ResourceNotFoundException;

    List<Membership> getAllMemberships();

    MembershipResponseDto updateMembership(long id, MembershipRequestDto membershipRequestDto);

    String deleteMembership(long id);

    MembershipPlanResponseDTOs getMembershipsByMemberId(long memberId);



}
