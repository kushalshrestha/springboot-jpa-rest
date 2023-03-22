package id_authentication.repositories;

import id_authentication.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{
    List<Plan> getMemberPlansById(Long id);

    @Query("select l.plan.id from Membership l join l.plan.locations where l.plan.id =:id")
    List<Location> findLocationsByPlanId(Long id);


}

