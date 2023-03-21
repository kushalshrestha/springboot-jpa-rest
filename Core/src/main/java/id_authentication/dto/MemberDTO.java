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
    private String password;
    private Role role;
   // private List<MemberShipDTO> memberships;
   // private List<BadgeDTO> badges = new ArrayList<BadgeDTO>();

//    public MemberDTO(List<MemberShipDTO> memberships, List<BadgeDTO>badges) {
//
//    }
//
//    public MemberDTO(long id, String firstName, String lastName, List<MemberShipDTO> memberships,
//                     List<BadgeDTO> badges, String userName, String password) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.password = password;
//        this.memberships = memberships;
//        this.badges = badges;
//    }

}
