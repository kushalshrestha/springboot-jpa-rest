package id_authentication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@NoArgsConstructor
public class LocationTimeSlotDTO {
    private long id;
    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;


}
