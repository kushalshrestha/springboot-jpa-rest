package id_authentication.repositories;

import id_authentication.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    @Query(value = "update transaction set transaction_id=:transactionId where id=:id", nativeQuery = true)
    void updateTransactionId(long id, long memberId);
}
