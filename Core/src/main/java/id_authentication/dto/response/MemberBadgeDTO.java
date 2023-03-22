package id_authentication.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberBadgeDTO {
    private long id;
    private String badgeNumber;
    private LocalDate expiryDate;
    private String status;
}
