package id_authentication.dto.collection;

import id_authentication.dto.TransactionDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class TransactionDTOs {
    private List<TransactionDTO> transactions=new ArrayList<TransactionDTO>();

    public void addTransactionDTO(TransactionDTO transactionDTO) {
        transactions.add(transactionDTO);
    }
}
