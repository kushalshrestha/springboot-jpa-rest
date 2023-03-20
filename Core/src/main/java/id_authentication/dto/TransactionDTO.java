package id_authentication.dto;

import id_authentication.domain.Location;
import id_authentication.domain.Plan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class TransactionDTO {
    private long id;
    private LocalDateTime dateTime;
    private String TransactionType;
    private Location location;
    private Plan plan;

    public TransactionDTO(long id, LocalDateTime dateTime, String transactionType,
                          Location location, Plan plan) {
        this.id = id;
        this.dateTime = dateTime;
        TransactionType = transactionType;
        this.location = location;
        this.plan = plan;
    }


}
