package id_authentication.dto.response;

import id_authentication.dto.LocationDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanWithLocationDTO {
    private long id;
    private String name;
    private String description;
    private List<LocationDTO> locations=new ArrayList<LocationDTO>();
}
