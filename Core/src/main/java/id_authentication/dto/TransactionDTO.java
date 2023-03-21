package id_authentication.dto;

import id_authentication.dto.response.TransactionLocationDTO;
import id_authentication.dto.response.TransactionPlanDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class TransactionDTO {
    private long id;
    private LocalDateTime dateTime;
    private String TransactionType;
    private TransactionLocationDTO location;
    private TransactionPlanDTO plan;

}
