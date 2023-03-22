package id_authentication.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MemberCreateDTO {
    //private long id;
    @NotEmpty(message = "Member number is required")
    private String memberNumber;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @NotEmpty(message = "Role is required")
    private Long roleId;
}
