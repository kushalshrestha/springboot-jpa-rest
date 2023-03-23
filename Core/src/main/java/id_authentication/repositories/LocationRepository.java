package id_authentication.repositories;


import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface LocationRepository extends JpaRepository<Location, Long> {


    @Query("select l from Location l join fetch l.timeSlots")
    List<LocationTimeSlot> getLocationsTimeSlotById(Long id);

   @Modifying
   @Query(value = "update location  set plan_id = :planId where id = :locationId", nativeQuery = true)
   void updatePlanId(@Param("locationId")long locationId, @Param("planId") long planId);
}
