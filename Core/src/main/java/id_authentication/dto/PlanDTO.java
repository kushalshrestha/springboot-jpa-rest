package id_authentication.dto;

import id_authentication.domain.Location;
import id_authentication.domain.RolePlanLimit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;
    private List<Location> locations=new ArrayList<Location>();
    private List<RolePlanLimit> rolePlanLimit;

    public PlanDTO(long id, String name, String description, List<Location> locations,
                   List<RolePlanLimit> rolePlanLimit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locations = locations;
        this.rolePlanLimit = rolePlanLimit;
    }

}
