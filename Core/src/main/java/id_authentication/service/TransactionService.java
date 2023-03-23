package id_authentication.service;

import id_authentication.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import id_authentication.dto.response.TransactionStatusDTO;

@Service
public interface TransactionService {
    TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO);

    TransactionStatusDTO addTransaction(long badgeId, long planId, long locationId);

    boolean checkIsAllowed(long badgeId, long planId, long locationId);

    List<TransactionDTO> getAllTransactions();

    TransactionDTO getTransaction(long id);

    String deleteTransaction(long id);
}
