package id_authentication.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "badge_number", length=50, unique = true)
    @NonNull
    private String badgeNumber;

    @NonNull
    @Column(name="expiry_date")
    private LocalDate expiryDate;
    @NonNull
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="badge_id")
    private List<Transaction> transactions;



}
