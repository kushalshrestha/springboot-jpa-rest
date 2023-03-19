package id_authentication.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class CheckInRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @NonNull
    private Member member;

    @OneToOne
    @JoinColumn(name = "plans_id")
    @NonNull
    private Plan plan;

    private int count;

    @OneToOne
    @JoinColumn(name = "roles_id")
    @NonNull
    private Role role;


}
