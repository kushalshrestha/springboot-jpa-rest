package id_authentication.dto;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;

}
