package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name="expiry_date")
    private LocalDate expiryDate;
    @NonNull
    private String status;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name="badge_id")
    private List<Transaction> transactions;

    public void addTransaction(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
    }

    public void removeTransactions(Transaction transaction) {
        if (transactions != null) {
            transactions.remove(transaction);
        }
    }

}
