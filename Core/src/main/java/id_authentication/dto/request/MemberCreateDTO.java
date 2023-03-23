package id_authentication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberCreateDTO {
    private long id;
    private String memberNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    private Long roleId;
}
