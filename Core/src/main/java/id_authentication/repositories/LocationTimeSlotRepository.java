package id_authentication.repositories;

import id_authentication.domain.LocationTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTimeSlotRepository extends JpaRepository<LocationTimeSlot, Long>{
}
