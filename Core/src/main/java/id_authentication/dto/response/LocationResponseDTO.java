package id_authentication.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class LocationResponseDTO {
    private long id;
    private String name;
    private String description;
    private int capacity;
}
