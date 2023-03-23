package id_authentication.dto;

import id_authentication.domain.Badge;
import id_authentication.domain.Membership;
import id_authentication.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MemberDTO {
    private long id;
    private String memberNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private Role role;

}
