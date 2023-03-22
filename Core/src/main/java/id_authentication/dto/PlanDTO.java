package id_authentication.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;
    private List<LocationDTO> locations=new ArrayList<>();
    private List<RolePlanLimitDTO> rolePlanLimit;
    private List<LocationDTO> locationDTOList;
    public PlanDTO(long id, String name, String description, List<LocationDTO> locations,
                   List<RolePlanLimitDTO> rolePlanLimit) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.locations = locations;
        this.rolePlanLimit = rolePlanLimit;
    }

}
