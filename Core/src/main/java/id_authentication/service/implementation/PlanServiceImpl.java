package id_authentication.service.implementation;


import id_authentication.domain.Plan;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.PlanDTO;
import id_authentication.dto.collection.PlanDTOs;
import id_authentication.errorhandler.ResourceNotFoundException;
import id_authentication.repositories.*;
import id_authentication.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired

    private ModelMapper modelMapper;


    @Override
    public List<PlanDTO> getPlansForMemberById(Long id) {

       List<Plan>  plans = planRepository.getMemberPlansById(id);
       List<PlanDTO> createdPlanDTO = plans.stream()
                .map(plan ->modelMapper.map(plan,PlanDTO.class))
                .collect(Collectors.toList());
        return createdPlanDTO;

    }

    @Override
    public PlanDTO createPlanForMember(PlanDTO planDTO) {
        Plan plan = modelMapper.map(planDTO,Plan.class);
        return modelMapper.map(planRepository.save(plan),PlanDTO.class);
    }

    @Override
    public void deletePlanForMember(Long id) {
        Optional<Plan> optionalPlan = planRepository.findById(id);
        if(optionalPlan.isPresent())
        planRepository.deleteById(id);
        else throw new ResourceNotFoundException("PLAN DOESN'T EXIST TO DELETE FOR MEMBER ID : " + id);
    }

    @Override
    public PlanDTO updatePlanForMember(Long id , PlanDTO planDTO) {

        Optional<Plan> optionalPlan = planRepository.findById(id);
        if(optionalPlan.isPresent()){
            Plan foundPlan = optionalPlan.get();
            foundPlan.setDescription(planDTO.getDescription());
            foundPlan.setName(planDTO.getName());
            return modelMapper.map(planRepository.save(foundPlan),PlanDTO.class);
        }
        else
            throw new ResourceNotFoundException("No Plan to Update For Member :" + id);

    }


    @Override
    public PlanDTOs getAllPlans(){
        PlanDTOs planDTOs = new PlanDTOs();
        planRepository.findAll().forEach(plan ->{
            PlanDTO planDTO = modelMapper.map(plan,PlanDTO.class);
            planDTOs.addPlan(planDTO);
        });

        return planDTOs;
    }
}
