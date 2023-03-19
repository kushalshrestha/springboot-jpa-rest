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
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(length = 50)
    private String type;

    @Column(name="start_date")
    @NonNull
    private LocalDateTime startDate;
    @Column(name = "end_date")
    @NonNull
    private LocalDateTime endDate;

    @ManyToOne
    @NonNull
    private Plan plan;
}
