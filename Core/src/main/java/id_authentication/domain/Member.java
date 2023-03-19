package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    @OneToMany
    private List<Membership> membership=new ArrayList<Membership>();

    @OneToMany(mappedBy = "member")
    private List<Badge> badges=new ArrayList<Badge>();
}
