package id_authentication.controller;

import id_authentication.dto.TransactionDTO;
import id_authentication.dto.response.TransactionStatusDTO;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.dto.request.TransactionCreateDTO;
import id_authentication.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody TransactionCreateDTO transactionCreateDTO) {
        TransactionStatusDTO transactionDTO = transactionService.addTransaction(transactionCreateDTO.getBadgeId(), transactionCreateDTO.getPlanId(), transactionCreateDTO.getLocationId());
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionDTO);
    }

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransaction(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable long id, @RequestBody TransactionDTO transactionRequestDto) {
        try {
            TransactionDTO transactionRepositoryDto = transactionService.updateTransaction(id, transactionRequestDto);
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
            return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
