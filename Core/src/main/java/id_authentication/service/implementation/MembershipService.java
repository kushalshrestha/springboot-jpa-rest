package id_authentication.service.implementation;

import id_authentication.domain.Member;
import id_authentication.domain.Membership;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.MemberShipDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.dto.collection.MembershipPlanResponseDTOs;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipPlanResponseDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.dto.response.PlanWithLocationDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.MemberRepository;
import id_authentication.repositories.MembershipRepository;
import id_authentication.service.IMembershipService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembershipService implements IMembershipService {

    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final MembershipRepository membershipRepository;

    @Autowired
    private MemberRepository memberRepository;

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
    public MembershipPlanResponseDTOs getMembershipsByMemberId(long memberId) {
        MembershipPlanResponseDTOs membershipPlanResponseDTOs = new MembershipPlanResponseDTOs();
        System.out.println("getting member for:"+memberId);
        Member member=memberRepository.findById(memberId).get();
        System.out.println("got member");
        member.getMemberships().forEach(membership -> System.out.println(membership.getPlan()));
        if (member.getMemberships().size() == 0) {
            throw new ResourceNotFoundException("No memberships found for member id " + memberId);
        }
        member.getMemberships().forEach(membership -> {
            MembershipPlanResponseDto dto = modelMapper.map(membership, MembershipPlanResponseDto.class);
            PlanWithLocationDTO plan = modelMapper.map(membership.getPlan(), PlanWithLocationDTO.class);
            membershipPlanResponseDTOs.add(modelMapper.map(membership, MembershipPlanResponseDto.class));
        });


        return membershipPlanResponseDTOs;
    }

    public void update(long id, Membership membership) {
        membershipRepository.save(membership);
    }


}
