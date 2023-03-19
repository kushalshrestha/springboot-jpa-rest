package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Badge {
    @Id
    @GeneratedValue
    private long id;

    private LocalDate ExpiryDate;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany
    @JoinColumn(name="badge_id")
    @Column(nullable = true)
    private List<Transaction> transactions;

}
