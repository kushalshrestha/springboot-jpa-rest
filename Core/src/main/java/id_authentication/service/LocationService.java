package id_authentication.service;

import id_authentication.domain.Location;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.request.LocationCreateDTO;
import id_authentication.dto.response.LocationWithTimeDTO;
import id_authentication.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocationService {
    LocationWithTimeDTO addLocation(LocationCreateDTO locationDTO);
    LocationDTO updateLocation(long id, LocationDTO locationDTO);
    String deleteLocation(long id);
    LocationWithTimeDTO getLocation(long id);
    List<LocationDTO> getAllLocations();
}
