package id_authentication.dto.request;

import id_authentication.domain.LocationTimeSlot;
import id_authentication.domain.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
public class LocationCreateDTO {
        private long id;
        private String name;
        private String description;
        private int capacity;
        private String locationType;
        private Set<LocationTimeSlot> timeSlots;
        private long planId;
    }



