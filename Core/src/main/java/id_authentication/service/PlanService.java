package id_authentication.service;

import id_authentication.dto.PlanDTO;
import id_authentication.dto.collection.LocationDTOs;
import id_authentication.dto.collection.PlanDTOs;

import java.util.List;

public interface PlanService {

    List<PlanDTO> getPlansForMemberById(Long id);

    PlanDTO createPlanForMember(PlanDTO planDTO);

    void deletePlanForMember(Long id);

    PlanDTO updatePlanForMember(Long id, PlanDTO planDTO);


    PlanDTOs getAllPlans();
    LocationDTOs getAllLocationsById(Long id);
}
