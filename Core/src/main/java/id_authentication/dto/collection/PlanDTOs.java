package id_authentication.dto.collection;

import id_authentication.dto.PlanDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanDTOs {

    List<PlanDTO> planDTOList = new ArrayList<PlanDTO>();

    public void addPlan(PlanDTO planDTO){
        planDTOList.add(planDTO);
    }
}
