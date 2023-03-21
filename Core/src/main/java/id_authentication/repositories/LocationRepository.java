package id_authentication.repositories;


import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


    @Query("select l from Location l join fetch l.timeSlots")
    List<LocationTimeSlot> getLocationsTimeSlotById(Long id);
}
