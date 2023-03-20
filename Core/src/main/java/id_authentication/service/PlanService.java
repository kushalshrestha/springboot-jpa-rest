package id_authentication.service;

import id_authentication.domain.Member;
import id_authentication.domain.Plan;
import id_authentication.dto.PlanDTO;
import id_authentication.repositories.MemberRepository;
import id_authentication.repositories.PlanRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;



    public ResponseEntity<List<Plan>> getPlansForMember(Long id){
        List<Plan> plans = planRepository.getMemberPlansById(id);
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

}
