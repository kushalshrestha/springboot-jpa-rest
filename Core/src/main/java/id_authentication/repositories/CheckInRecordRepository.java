package id_authentication.repositories;

import id_authentication.domain.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRecordRepository extends JpaRepository<CheckInRecord,Long> {
}
