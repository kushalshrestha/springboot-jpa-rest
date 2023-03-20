package id_authentication.repositories;

import id_authentication.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{


    List<Plan> getMemberPlansById(Long id);
}
