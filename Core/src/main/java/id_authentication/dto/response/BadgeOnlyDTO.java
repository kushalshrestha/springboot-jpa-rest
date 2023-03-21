package id_authentication.dto.response;

import id_authentication.domain.Member;
import id_authentication.dto.TransactionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class BadgeOnlyDTO {
    private long id;
    private String badgeNumber;
    private LocalDate expiryDate;
    private String status;

}
