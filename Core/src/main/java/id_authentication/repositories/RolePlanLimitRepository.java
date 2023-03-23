package id_authentication.repositories;

import id_authentication.domain.Role;
import id_authentication.domain.RolePlanLimit;
import id_authentication.dto.RolePlanLimitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RolePlanLimitRepository extends JpaRepository<RolePlanLimit, Long>{
    @Query("Select p.rolePlanLimit from Plan p join p.rolePlanLimit l where l.role.id= :roleId and p.id = :planId")
    Set<RolePlanLimitDTO> findRolePlanLimitWithRoleAndPlan(long roleId, long planId);

}
