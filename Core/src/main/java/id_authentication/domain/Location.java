package id_authentication.domain;

import lombok.*;


import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;

    private String description;
    private int capacity;
    private String type;

    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    @Column(name = "time_slot")
    private Set<LocationTimeSlot> timeSlots;

    public Location(@NonNull String name, String description, int capacity, String type, Set<LocationTimeSlot> timeSlots) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.type = type;
        this.timeSlots = timeSlots;
    }

}
