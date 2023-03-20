package id_authentication.DTOs;

import id_authentication.domain.LocationTimeSlot;

import java.util.ArrayList;
import java.util.List;

public class LocationDTO {
    private long id;
    private String name;
    private String description;
    private int capacity;
    private String type;
    private List<LocationTimeSlot> timeSlots=new ArrayList<LocationTimeSlot>();

    public LocationDTO(long id, String name, String description, int capacity,
                       String type, List<LocationTimeSlot> timeSlots) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.type = type;
        this.timeSlots = timeSlots;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LocationTimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<LocationTimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
