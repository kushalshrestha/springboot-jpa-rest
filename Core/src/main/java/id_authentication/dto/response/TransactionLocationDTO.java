package id_authentication.dto.response;

import id_authentication.domain.LocationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionLocationDTO {
    private long id;
    private String name;
    private LocationType locationType;
}
