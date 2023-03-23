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
    @Column(name = "type")
    private String locationType;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Set<LocationTimeSlot> timeSlots;

}
