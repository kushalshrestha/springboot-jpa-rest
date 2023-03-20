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

    public RolePlanLimitDTO(long id, String limitBy, int limitValue, Role role) {
        this.id = id;
        this.limitBy = limitBy;
        this.limitValue = limitValue;
        this.role = role;
    }
}
