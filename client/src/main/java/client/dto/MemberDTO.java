package client.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {
    private long id;
    private String memberNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;


    public MemberDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}

