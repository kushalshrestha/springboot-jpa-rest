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
    @Modifying
    @Query(value="update CheckinInformation  set plan_id= :planId, " +
            "location_id= :locationId,badge_id= :badgeId where id= :transactionId" , nativeQuery = true)
    void updateTransactionDetail(long badgeId, long planId, long locationId,long transactionId);
}
