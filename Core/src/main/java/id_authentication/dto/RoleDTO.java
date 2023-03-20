package id_authentication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
    private long id;
    private String name;

    public RoleDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
