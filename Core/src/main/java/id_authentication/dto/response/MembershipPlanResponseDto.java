package id_authentication.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MembershipPlanResponseDto {
    private long id;
    private String membershipNumber;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private PlanWithLocationDTO plan;
}
