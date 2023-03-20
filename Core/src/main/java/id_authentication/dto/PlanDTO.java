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
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {

    private long id;


    private String name;
    private String description;


    private List<Location> locations=new ArrayList<Location>();


    private List<RolePlanLimit> rolePlanLimit;


}
