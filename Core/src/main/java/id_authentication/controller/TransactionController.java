package id_authentication.controller;

import id_authentication.domain.Transaction;
import id_authentication.dto.TransactionDTO;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        try {
            List<Transaction> transactionList = transactionService.getAllTransactions();
            if (transactionList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CustomErrorType("No transactions found"));
            }
            List<TransactionDTO> transactionDTO = transactionList
                    .stream()
                    .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(transactionDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomErrorType("Error retrieving transactions: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable("id") long id) {
        try {
            TransactionDTO transactionDTO = transactionService.getTransaction(id);
            if (transactionDTO == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CustomErrorType("Invalid transaction with id " + id));
            }
            return ResponseEntity.status(HttpStatus.OK).body(transactionDTO);
        } catch (Exception e) {
            CustomErrorType customErrorType = new CustomErrorType("Error retrieving transaction with id " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customErrorType);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable long id, @RequestBody String text) {
        try {
            //TODO !!!Change RequestBody (See other controller)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(text);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorType(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable long id) {
        try {
            return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
