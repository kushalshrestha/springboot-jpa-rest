package id_authentication.service;

import id_authentication.domain.Membership;
import id_authentication.dto.response.MembershipResponseDto;

import java.net.http.HttpResponse;

public class MembershipAdapter {
    public static MembershipResponseDto getMemberShipDTOFromMembership(Membership membership) {
        MembershipResponseDto membershipResponseDto = new MembershipResponseDto();
        membershipResponseDto.setMembershipNumber(membership.getMembershipNumber());
        membershipResponseDto.setType(membership.getType());
        membershipResponseDto.setStartDate(membership.getStartDate());
        membershipResponseDto.setEndDate(membership.getEndDate());
//        membershipResponseDto.setPlanId(membership.getPlan());
        return membershipResponseDto;
    }
}
