package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    private String TransactionType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @NonNull
    private Location location;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "plan_id")
    private Plan plan;

}
