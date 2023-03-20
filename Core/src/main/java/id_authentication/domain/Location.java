package id_authentication.domain;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    @JoinColumn(name = "location_id")
    @Column(name = "time_slot")
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();

    public Location(@NonNull String name, String description, int capacity, String type, List<LocationTimeSlot> timeSlots) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.type = type;
        this.timeSlots = timeSlots;
    }

}
