package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RolePlanLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "limit_by")
    @NonNull
    private String limitBy;
    @Column(name = "limit_value")
    @NonNull
    private int limitValue;

    @OneToOne
    @NonNull
    public Role role;

}
