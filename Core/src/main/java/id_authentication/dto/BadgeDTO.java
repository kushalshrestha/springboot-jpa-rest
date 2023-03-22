package id_authentication.dto;

import id_authentication.domain.Member;
import id_authentication.domain.Transaction;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor

public class BadgeDTO {
    private long id;

    private String badgeNumber;
    private LocalDate expiryDate;
    private String status;
    private long memberId;
}
