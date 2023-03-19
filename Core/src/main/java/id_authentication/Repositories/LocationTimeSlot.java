package id_authentication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTimeSlot extends JpaRepository<LocationTimeSlot, Long> {
}
