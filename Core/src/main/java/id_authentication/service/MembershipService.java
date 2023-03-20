package id_authentication.service;

import id_authentication.domain.Member;
import id_authentication.domain.Membership;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.repositories.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService implements IMembershipService{

    private final ModelMapper modelMapper;
    private final MembershipRepository membershipRepository;
    @Override
    public MembershipResponseDto save(MembershipRequestDto membershipRequestDto) {
        Membership membership = modelMapper.map(membershipRequestDto, Membership.class);
        membershipRepository.save(membership);
        return MembershipAdapter.getMemberShipDTOFromMembership(membership);
    }

    public MembershipResponseDto getMembership(long id){
        Membership membership = membershipRepository.findById(id).get();
        modelMapper.map(membership, MembershipResponseDto.class);
        return null;
    }

    public List<Membership> getAllMemberships() {
        List<Membership> membershipsList = new ArrayList<Membership>();
        membershipRepository.findAll().forEach(membership->membershipsList.add(membership));
        return membershipsList;
    }

    @Override
    public MembershipResponseDto updateMembership(long id, MembershipRequestDto membershipRequestDto) {
        return null;
    }


    public void deleteMembership(long id) {
        membershipRepository.deleteById(id);
    }

    public void update(long id, Membership membership) {
        membershipRepository.save(membership);
    }


}
