package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Plan {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    @OneToMany
    private List<Location> locations=new ArrayList<Location>();
    @OneToMany
    @Column(name = "role_plan_limit", nullable = true)
    private List<RolePlanLimit> rolePlanLimit=new ArrayList<RolePlanLimit>();
}
