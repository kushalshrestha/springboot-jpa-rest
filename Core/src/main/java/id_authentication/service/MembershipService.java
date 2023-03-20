package id_authentication.service;

import id_authentication.domain.Membership;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.repositories.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService implements IMembershipService{

    private final ModelMapper modelMapper;
    private final MembershipRepository membershipRepository;
    @Override
    public HttpResponse save(String memberNumber, MembershipRequestDto membershipRequestDto) {
        Membership membership = modelMapper.map(membershipRequestDto, Membership.class);
        membership.setMembershipNumber(memberNumber);
        membershipRepository.save(membership);
        

        return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
    }

    @Override
    public List<MembershipResponseDto> findAllByMembers(long memberId) {
        return null;
    }

    @Override
    public List<MembershipResponseDto> findAll() {
        return null;
    }
}
