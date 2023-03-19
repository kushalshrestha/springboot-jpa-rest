package id_authentication.service;

import id_authentication.domain.Location;
import id_authentication.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public void addLocation(Location location){

        locationRepository.save(location);
    }

}
