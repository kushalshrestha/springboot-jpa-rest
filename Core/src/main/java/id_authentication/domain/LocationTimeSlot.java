package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Data
@NoArgsConstructor
public class LocationTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "day_of_week")
    @NonNull
    private int dayOfWeek;
    @Column(name = "start_time")
    @NonNull
    private LocalTime startTime;
    @Column(name = "end_time")
    @NonNull
    private LocalTime endTime;


    public LocationTimeSlot(@NonNull int dayOfWeek, @NonNull LocalTime startTime, @NonNull LocalTime endTime){

            this.dayOfWeek = dayOfWeek;
            this.startTime = startTime;
            this.endTime = endTime;
        }

}