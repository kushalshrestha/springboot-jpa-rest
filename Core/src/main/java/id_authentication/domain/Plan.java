package id_authentication.domain;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PlanInfo")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE ,fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private List<Membership> membership;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "plan_id")
    private Set<Location> locations;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "role_plan_limit")
    @JoinColumn(name = "plan_id")
    private Set<RolePlanLimit> rolePlanLimit ;



}
