package id_authentication.repositories;


import id_authentication.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LocationRepository extends JpaRepository<Location, Long> {
}
