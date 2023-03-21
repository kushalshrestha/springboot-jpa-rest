package id_authentication.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MembershipRequestDto {

    private long id;
    private String membershipNumber;
    private long planId;
    private String type;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private long memberId;


}
