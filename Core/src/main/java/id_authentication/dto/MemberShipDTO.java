package id_authentication.dto;

import id_authentication.domain.Plan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MemberShipDTO {
    private long id;
    private String membershipNumber;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Plan plan;

    public MemberShipDTO(long id, String membershipNumber, String type, LocalDateTime startDate,
                         LocalDateTime endDate, Plan plan) {
        this.id = id;
        this.membershipNumber = membershipNumber;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }


}
