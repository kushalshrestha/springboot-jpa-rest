package id_authentication.controller;



import id_authentication.dto.PlanDTO;
import id_authentication.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/{id}")

    public ResponseEntity<?> getPlan(@PathVariable Long id){
        List<PlanDTO> planDTO = planService.getPlansForMemberById(id);
        return new ResponseEntity<>(planDTO, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createAPlan(@RequestBody PlanDTO planDTO){
        PlanDTO p = planService.createPlanForMember(planDTO);
        return new ResponseEntity<PlanDTO>(planDTO,HttpStatus.OK);

    }


    @PutMapping("/update/{planId}")
    public ResponseEntity<?> updatePlan(@RequestBody PlanDTO planDTO,@PathVariable Long planId){
        PlanDTO p = planService.updatePlanForMember(planId,planDTO);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }


    @DeleteMapping("/remove/{memberId}")

    public ResponseEntity<?> deletePlan(@PathVariable Long memberId){
        planService.deletePlanForMember(memberId);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }





}