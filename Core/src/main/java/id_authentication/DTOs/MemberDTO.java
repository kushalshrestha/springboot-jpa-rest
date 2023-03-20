package id_authentication.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public MemberDTO(long id, String firstName, String lastName,
                     String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }


}
