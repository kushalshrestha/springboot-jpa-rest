package id_authentication.service;

import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;

import java.net.http.HttpResponse;
import java.util.List;

public interface IMembershipService {
    HttpResponse save (String memberNumber, MembershipRequestDto membershipRequestDto);

    List<MembershipResponseDto> findAllByMembers(long memberId);

    List<MembershipResponseDto> findAll();
}
