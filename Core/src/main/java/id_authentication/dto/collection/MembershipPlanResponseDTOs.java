package id_authentication.dto.collection;

import id_authentication.dto.PlanDTO;
import id_authentication.dto.response.MembershipPlanResponseDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MembershipPlanResponseDTOs {
    List<MembershipPlanResponseDto> memberships = new ArrayList<MembershipPlanResponseDto>();

    public void add(MembershipPlanResponseDto membershipPlanResponseDto){
        memberships.add(membershipPlanResponseDto);
    }
}
