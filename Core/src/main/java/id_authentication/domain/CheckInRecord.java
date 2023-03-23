package id_authentication.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class CheckInRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plans_id")
    @NonNull
    private Plan plan;

    private int count;

    @OneToOne
    @JoinColumn(name = "roles_id")
    @NonNull
    private Role role;

    private LocalDateTime lastCheckIn;

    public CheckInRecord(int count, LocalDateTime lastCheckIn) {
        this.count = count;
        this.lastCheckIn = lastCheckIn;
    }
}
