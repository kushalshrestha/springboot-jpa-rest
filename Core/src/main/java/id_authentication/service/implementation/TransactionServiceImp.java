package id_authentication.service.implementation;

import id_authentication.domain.Transaction;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import id_authentication.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

//import javax.transaction.Transaction;
import java.util.Optional;

public class TransactionServiceImp implements TransactionService {
    @Autowired
     private  ModelMapper modelMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()){
            Transaction foundTran = transactionOptional.get();
            foundTran.setDateTime(transactionDTO.getDateTime());
            foundTran.setTransactionType(transactionDTO.getTransactionType());
            return modelMapper.map(transactionRepository.save(foundTran), TransactionDTO.class);
         }else {
            throw new ResourceNotFoundException("Transaction not found" + id);

        }

    }
}
