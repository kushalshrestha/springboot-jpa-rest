package id_authentication.service.implementation;

import id_authentication.domain.Transaction;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import id_authentication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public String deleteTransaction(long id) {
        Optional<Transaction> transasctionOptional = transactionRepository.findById(id);
        if (transasctionOptional.isPresent()) {
            transactionRepository.deleteById(id);
            return "Transaction deleted";
        } else {
            throw new ResourceNotFoundException("Transaction not found with ID: " + id);
        }
    }
}
