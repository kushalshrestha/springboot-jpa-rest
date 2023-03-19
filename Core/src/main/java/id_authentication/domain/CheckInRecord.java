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

    @OneToMany
    @JoinColumn(name = "plans_id")
    @NonNull
    private List<Plan> plan = new ArrayList<>();

    private int count;

    @OneToMany
    @JoinColumn(name = "roles_id")
    @NonNull
    private List<Role> role = new ArrayList<>();

    private CheckStatus checkStatus;

    public void  updateCount(){
        if(checkStatus.APPROVED == CheckStatus.APPROVED)
        this.count = count++;
    }



}
