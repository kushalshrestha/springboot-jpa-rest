package id_authentication.dto;

import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
import id_authentication.domain.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class LocationDTO {
    private long id;
    private String name;
    private String description;
    private int capacity;
    private LocationType locationType;
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();
}
