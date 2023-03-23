package id_authentication.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TransactionStatusDTO {
    private long id;
    private LocalDateTime dateTime;
    private String TransactionType;
}
