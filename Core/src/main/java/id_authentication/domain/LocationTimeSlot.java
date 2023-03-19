package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LocationTimeSlot {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="day_of_week")
    @NonNull
    private String dayOfWeek;
    @Column(name = "start_time")
    @NonNull
    private LocalDateTime startTime;
    @Column(name = "end_time")
    @NonNull
    private LocalDateTime endTime;


}
