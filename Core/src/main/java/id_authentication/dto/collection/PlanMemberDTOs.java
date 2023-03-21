package id_authentication.dto.collection;

import id_authentication.dto.response.PlanMemberDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanMemberDTOs {
    private List<PlanMemberDTO> members=new ArrayList<PlanMemberDTO>();


    public void addMemberDTO(PlanMemberDTO planMemberDTO) {
        members.add(planMemberDTO);
    }
}
