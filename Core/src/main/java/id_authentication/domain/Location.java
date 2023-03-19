package id_authentication.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String name;
    private String description;
    private int capacity;
    private String type;
    @OneToMany
    @JoinColumn(name = "location_id")
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();
}
