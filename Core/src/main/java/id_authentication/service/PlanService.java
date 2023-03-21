package id_authentication.service;
import id_authentication.dto.PlanDTO;


import java.util.List;

public interface PlanService {

    List<PlanDTO> getPlansForMemberById(Long id);

    PlanDTO createPlanForMember(PlanDTO planDTO);

     void deletePlanForMember(Long id);

     PlanDTO updatePlanForMember(Long id , PlanDTO planDTO);

}
