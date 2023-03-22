package id_authentication.service.implementation;

import id_authentication.domain.Transaction;
import id_authentication.dto.TransactionDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import id_authentication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionRepository.findAll().forEach(transaction -> transactionList.add(transaction));
        return transactionList;
    }

    @Override
    public TransactionDTO getTransaction(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id " + id));
        return modelMapper.map(transaction, TransactionDTO.class);
    }

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
