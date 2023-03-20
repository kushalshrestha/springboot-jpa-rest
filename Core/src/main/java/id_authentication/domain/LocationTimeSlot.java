package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class LocationTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="day_of_week")
    @NonNull
    private int dayOfWeek;
    @Column(name = "start_time")
    @NonNull
    private LocalDateTime startTime;
    @Column(name = "end_time")
    @NonNull
    private LocalDateTime endTime;


//    public LocationTimeSlot(@NonNull int dayOfWeek, @NonNull LocalDateTime startTime, @NonNull LocalDateTime endTime) {
//        this.dayOfWeek = dayOfWeek;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }
}
