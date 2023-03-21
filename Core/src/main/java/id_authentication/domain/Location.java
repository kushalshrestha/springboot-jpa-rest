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


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private LocationType locationType;
    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "location_id")
    @Column(name = "time_slot")
    private Set<LocationTimeSlot> timeSlots;

}
