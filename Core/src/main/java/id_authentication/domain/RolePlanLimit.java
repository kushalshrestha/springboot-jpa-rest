package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

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
    @NonNull
    private String limitBy;
    @Column(name = "limit_value")
    @NonNull
    private int limitValue;

    @OneToOne
    @NonNull
    public Role role;

}
