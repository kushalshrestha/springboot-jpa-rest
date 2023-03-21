package id_authentication.repositories;

import id_authentication.domain.Location;
import id_authentication.domain.Plan;
import id_authentication.domain.RolePlanLimit;
import id_authentication.dto.PlanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> getMemberPlansById(Long id);

}

