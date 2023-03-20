package id_authentication.dto;

import id_authentication.domain.LocationTimeSlot;
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
    private String type;
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();

    public LocationDTO(long id, String name, String description, int capacity,
                       String type, List<LocationTimeSlot> timeSlots) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.type = type;
        this.timeSlots = timeSlots;
    }


}
