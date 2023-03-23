package id_authentication.dto.collection;

import id_authentication.dto.LocationDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationDTOs {
    List<LocationDTO> locations = new ArrayList<>();
    public void addLocation(LocationDTO locationDTO){
        locations.add(locationDTO);
    }
}
