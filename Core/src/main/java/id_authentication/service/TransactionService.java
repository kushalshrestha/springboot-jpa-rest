package id_authentication.service;

import id_authentication.dto.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO);

}
