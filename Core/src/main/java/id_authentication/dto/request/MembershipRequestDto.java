package id_authentication.dto.request;

import lombok.Data;

@Data
public class MembershipRequestDto {
    private String membershipNumber;
    private long planId;
}
