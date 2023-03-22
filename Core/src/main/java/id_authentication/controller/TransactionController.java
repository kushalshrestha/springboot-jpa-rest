package id_authentication.controller;

import id_authentication.dto.request.TransactionCreateDTO;
import id_authentication.dto.response.TransactionStatusDTO;
import id_authentication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody TransactionCreateDTO transactionCreateDTO){
        TransactionStatusDTO transactionDTO= transactionService.addTransaction(transactionCreateDTO.getBadgeId(),transactionCreateDTO.getPlanId(),transactionCreateDTO.getLocationId());

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionDTO);
    }
}
