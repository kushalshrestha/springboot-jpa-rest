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
@RequiredArgsConstructor
public class Badge {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    @Column(name="expiry_date")
    private LocalDate ExpiryDate;
    @NonNull
    @Column(name="is_active")
    private Boolean isActive;

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
