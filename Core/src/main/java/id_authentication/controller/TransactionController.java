package id_authentication.controller;

import id_authentication.domain.Transaction;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
//    @Autowired
//    private TransactionService transactionService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        try {
            //TODO
            return ResponseEntity.status(HttpStatus.OK).body("HELLO");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CustomErrorType("Error retrieving transactions: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable("id") long id) {
        try {
            //TODO
            return ResponseEntity.status(HttpStatus.OK).body("GET METHOD - by ID");
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
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new CustomErrorType(e.getMessage()));
        }
    }
}
