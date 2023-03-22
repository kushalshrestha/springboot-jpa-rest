package id_authentication.dto.request;

import id_authentication.domain.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LocationCreateDTO {
        private long id;
        private String name;
        private String description;
        private int capacity;
        private LocationType locationType;
        private long planId;
    }



