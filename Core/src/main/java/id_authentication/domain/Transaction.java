package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dateTime;
    private String TransactionType;

    @ManyToOne
    private Location location;
    @ManyToOne
    private Plan plan;

}
