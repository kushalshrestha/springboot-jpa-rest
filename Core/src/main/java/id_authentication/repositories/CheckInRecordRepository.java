package id_authentication.repositories;

import id_authentication.domain.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CheckInRecordRepository extends JpaRepository<CheckInRecord, Long> {
    @Query(value = "select c.* from checkinrecord c where plans_id= :planId and member_id= :memberId", nativeQuery = true)
    List<CheckInRecord> findCheckInRecordWithMember(@Param("memberId") long memberId, @Param("planId") long planId);

    @Modifying
    @Query(value = "update CheckInRecord  set count= count+1, lastCheckIn=getdate() " +
            " where id= :checkInRecordId", nativeQuery = true)
    void updateCheckInRecordCount(Long checkInRecordId);

    @Modifying
    @Query(value = "update CheckInRecord  set plans_id= :planId, " +
            "roles_id= :roleId, member_id= :memberId where id= :checkInRecordId", nativeQuery = true)
    void updateCheckInRecordDetail(Long checkInRecordId, long planId, long memberId, long roleId);

}
