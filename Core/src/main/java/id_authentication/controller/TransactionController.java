package id_authentication.controller;

import id_authentication.dto.LocationDTO;
import id_authentication.dto.TransactionDTO;
import id_authentication.dto.request.MembershipRequestDto;
import id_authentication.dto.response.MembershipResponseDto;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

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
    public ResponseEntity<?> updateTransaction(@PathVariable long id, @RequestBody TransactionDTO transactionRequestDto) {
        try {
            TransactionDTO transactionRepositoryDto =transactionService.updateTransaction(id,transactionRequestDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(transactionRepositoryDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorType(e.getMessage()));
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable long id) {
        try {
            //TODO
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted!!");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new CustomErrorType(e.getMessage()));
        }
    }
}
