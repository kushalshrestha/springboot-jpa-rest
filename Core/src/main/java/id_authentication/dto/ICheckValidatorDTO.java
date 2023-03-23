package id_authentication.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ICheckValidatorDTO {

    long getBadgeId();
    LocalDate getExpiryDate();
    String getStatus();
    long getMemberId();
    long getRoleId();
    LocalDateTime getMembershipStartDate();
    LocalDateTime getMembershipEndDate();
    String getType();
    long getPlanId();
    long getLocationId();
    int getDayOfWeek();
    LocalTime getStartTime();
    LocalTime getEndTime();


}
