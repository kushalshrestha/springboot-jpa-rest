package id_authentication.service.implementation;

import id_authentication.domain.Membership;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.MembershipRepository;
import id_authentication.service.IMembershipService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipService implements IMembershipService {

    private final ModelMapper modelMapper;
    private final MembershipRepository membershipRepository;

    @Override
    public MembershipResponseDto save(MembershipRequestDto membershipRequestDto) {
        Membership membership = modelMapper.map(membershipRequestDto, Membership.class);
        Membership savedMembership = membershipRepository.save(membership);
        membershipRepository.updateMemberId(savedMembership.getId(), membershipRequestDto.getMemberId());
        return modelMapper.map(savedMembership, MembershipResponseDto.class);
    }

    @Override
    public MembershipResponseDto getMembership(long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Membership not found with id " + id));
        return modelMapper.map(membership, MembershipResponseDto.class);
    }

    public List<Membership> getAllMemberships() {
        List<Membership> membershipsList = new ArrayList<Membership>();
        membershipRepository.findAll().forEach(membership -> membershipsList.add(membership));
        return membershipsList;
    }

    @Override
    public MembershipResponseDto updateMembership(long id, MembershipRequestDto membershipRequestDto) {
        Optional<Membership> membershipOptional = membershipRepository.findById(id);
        if (membershipOptional.isPresent()) {
            Membership membership = membershipOptional.get();
            membership.setStartDate(membershipRequestDto.getStartDate());
            membership.setEndDate(membershipRequestDto.getEndDate());
            membership.setMembershipNumber(membershipRequestDto.getMembershipNumber());
            membership.setType(membershipRequestDto.getType());
            return modelMapper.map(membershipRepository.save(membership), MembershipResponseDto.class);
        } else {
            throw new ResourceNotFoundException("Membership does not exist!!");
        }
    }


    public String deleteMembership(long id) {
        Optional<Membership> membershipOptional = membershipRepository.findById(id);
        if (membershipOptional.isPresent()) {
            membershipRepository.deleteById(id);
            return "Membership deleted";
        } else {
            throw new ResourceNotFoundException("Couldn't find the membership with id: " + id);
        }
    }

    @Override
    public List<MembershipResponseDto> findAllByMemberId(String memberId) {
        //TODO
        return null;
    }

    public void update(long id, Membership membership) {
        membershipRepository.save(membership);
    }


}
