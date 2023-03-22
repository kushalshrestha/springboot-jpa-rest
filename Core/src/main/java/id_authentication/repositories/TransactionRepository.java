package id_authentication.repositories;

import id_authentication.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
            value="select b.id as badgeId,b.expiry_date, b.status, m.id as member_id, m.role_id,ms.start_date as membership_startdate, ms.end_date as membership_enddate, ms.type ,p.id as plan_id, l.id as location_id, lts.day_of_week, lts.start_time, lts.end_time " +
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
                    "and ms.plan_id= :planId " +
                    "and l.id= :locationId " +
                    "and lts.day_of_week=DATEPART(dw,GETDATE()) " +
                    "and lts.start_time <= Convert(Time, GetDate()) " +
                    "and lts.end_time >= Convert(Time, GetDate()); "
            ,nativeQuery = true
    )
    Object[] extractDetails(long badgeId, long planId, long locationId);
}
