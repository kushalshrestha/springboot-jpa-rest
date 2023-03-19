package id_authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Plan extends JpaRepository<Plan, Long>{
}
