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
    private Member member;
    private List<Transaction> transactions;

    public BadgeDTO(long id, LocalDate expiryDate, String status,
                    Member member, List<Transaction> transactions) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.status = status;
        this.member = member;
        this.transactions = transactions;
    }


}
