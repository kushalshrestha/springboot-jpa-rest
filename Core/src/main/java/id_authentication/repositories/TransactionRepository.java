package id_authentication.repositories;

import id_authentication.domain.Transaction;
import id_authentication.dto.ICheckValidatorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    @Query(value = "update transaction set transaction_id=:transactionId where id=:id", nativeQuery = true)
    void updateTransactionId(long id, long transactionId);
    @Modifying
    @Query(value="update CheckinInformation  set plan_id= :planId, " +
            "location_id= :locationId,badge_id= :badgeId where id= :transactionId" , nativeQuery = true)
    void updateTransactionDetail(long badgeId, long planId, long locationId,long transactionId);



    @Query(
            value="select top 1 b.id as badgeId " +
                    ",b.expiry_date as expiryDate, b.status as status, m.id as memberId, m.role_id as roleId,ms.start_date as membershipStartDate, ms.end_date as membershipEndDate, ms.type as type ,p.id as planId, l.id as locationId, lts.day_of_week as dayOfWeek, lts.start_time as startTime, lts.end_time as endTime " +
                    "from badge b " +
                    "inner join member m " +
                    "on b.member_id=m.id " +
                    "inner join membership ms " +
                    "on ms.member_id=m.id " +
                    "inner join planinfo p " +
                    "on ms.plan_id = p.id " +
                    "inner join location l " +
                    "on l.plan_id = p.id " +
                    "inner join locationtimeslot lts " +
                    "on lts.location_id = l.id " +
                    "where b.id= :badgeId " +
                    "and convert(Date, GetDate()) < b.expiry_date " +
                    "and upper(b.status)='ACTIVE'" +
                    "and ms.plan_id= :planId " +
                    "and l.id= :locationId " +
                    "and lts.day_of_week=DATEPART(dw,GETDATE()) " +
                    "and convert(Time,lts.start_time) <= Convert(Time, GetDate()) " +
                    "and convert(Time,lts.end_time) >= Convert(Time, GetDate()); "
            ,nativeQuery = true
    )
    ICheckValidatorDTO extractDetails(@Param("badgeId") long badgeId, @Param("planId") long planId, @Param("locationId") long locationId);
}
