package id_authentication.service;

import id_authentication.domain.Transaction;
import id_authentication.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    List<Transaction> getAllTransactions();
    TransactionDTO getTransaction(long id);
    String deleteTransaction(long id);
}