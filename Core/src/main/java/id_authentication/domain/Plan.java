package id_authentication.domain;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PlanInfo")
@NoArgsConstructor
@Data
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

    public Plan(long id, @NonNull String name, String description, List<Membership> membership, Set<Location> locations, Set<RolePlanLimit> rolePlanLimit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.membership = membership;
        this.locations = locations;
        this.rolePlanLimit = rolePlanLimit;
    }

    public void addRole(RolePlanLimit role) {
        if (rolePlanLimit == null) {
            rolePlanLimit = new HashSet<>();
        }
        rolePlanLimit.add(role);
    }

    public void removeRole(RolePlanLimit role) {
        if (rolePlanLimit != null) {
            rolePlanLimit.remove(role);
        }
    }

}
