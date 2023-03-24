package id_authentication.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;
    private List<LocationDTO> locations=new ArrayList<>();


}
