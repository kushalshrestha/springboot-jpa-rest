package id_authentication.repositories;

import id_authentication.domain.RolePlanLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePlanLimitRepository extends JpaRepository<RolePlanLimit, Long>{

}
