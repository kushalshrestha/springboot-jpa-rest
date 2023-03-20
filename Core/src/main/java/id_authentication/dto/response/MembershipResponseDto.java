package id_authentication.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MembershipResponseDto {
    private long id;
    private String membershipNumber;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long planId;
}
