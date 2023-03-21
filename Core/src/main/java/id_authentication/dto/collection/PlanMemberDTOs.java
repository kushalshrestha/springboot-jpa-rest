package id_authentication.dto.collection;

import id_authentication.dto.response.PlanOnlyDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanMemberDTOs {
    private List<PlanOnlyDTO> members=new ArrayList<PlanOnlyDTO>();


    public void addMemberDTO(PlanOnlyDTO planMemberDTO) {
        members.add(planMemberDTO);
    }
}
