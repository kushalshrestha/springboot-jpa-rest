package id_authentication.dto.response;

import id_authentication.dto.LocationTimeSlotDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class LocationWithTimeDTO {
    private long id;
    private String name;
    private String description;
    private int capacity;
    private String locationType;

    private Set<LocationTimeSlotDTO> locationTimeSlots;

}
