package id_authentication.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class CheckInRecord {

    @Id
    @GeneratedValue
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

    private Date lastCheckIn;

}
