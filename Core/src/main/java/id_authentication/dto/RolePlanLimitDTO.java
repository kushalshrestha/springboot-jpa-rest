package id_authentication.dto;

import id_authentication.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolePlanLimitDTO {
    private long id;
    private String limitBy;
    private int limitValue;
    public Role role;

}
