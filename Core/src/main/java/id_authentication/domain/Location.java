package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String name;

    private String description;
    private int capacity;
    private String type;
    @OneToMany
    @JoinColumn(name = "location_id")
    @Column(name = "time_slot")
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();
}
