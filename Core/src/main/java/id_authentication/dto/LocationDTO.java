package id_authentication.dto;

import id_authentication.domain.LocationTimeSlot;
import id_authentication.domain.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class LocationDTO {
    private long id;
    private String name;
    private String description;
    private int capacity;
    private String locationType;


}
