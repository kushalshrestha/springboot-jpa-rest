package id_authentication.dto.response;

import id_authentication.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MemberDetailDTO {
    private long id;
    private String memberNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private Role role;
     private List<MemberBadgeDTO> badges = new ArrayList<MemberBadgeDTO>();
}
