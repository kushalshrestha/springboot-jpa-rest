package id_authentication.dto.response;

import id_authentication.domain.Plan;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MembershipResponseDto {
    private long id;
    private String membershipNumber;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long planId;
}
