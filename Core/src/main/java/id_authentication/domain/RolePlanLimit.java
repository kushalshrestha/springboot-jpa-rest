package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RolePlanLimit {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "limit_by")
    private String limitBy;
    @Column(name = "limit_value")
    private int limitValue;

    @OneToOne
    public Role role;

}
