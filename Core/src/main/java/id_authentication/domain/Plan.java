package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PlanInfo")
@Data
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private List<Location> locations=new ArrayList<Location>();
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @Column(name = "role_plan_limit")
    @JoinColumn(name = "plan_id")
    private List<RolePlanLimit> rolePlanLimit;

    public void addRole(RolePlanLimit role) {
        if (rolePlanLimit == null) {
            rolePlanLimit = new ArrayList<>();
        }
        rolePlanLimit.add(role);
    }

    public void removeRole(RolePlanLimit role) {
        if (rolePlanLimit != null) {
            rolePlanLimit.remove(role);
        }
    }
}
