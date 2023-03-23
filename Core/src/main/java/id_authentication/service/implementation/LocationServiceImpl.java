package id_authentication.service.implementation;

import id_authentication.domain.Location;
import id_authentication.dto.LocationDTO;
import id_authentication.dto.request.LocationCreateDTO;
import id_authentication.dto.response.LocationWithTimeDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.LocationRepository;
import id_authentication.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LocationWithTimeDTO addLocation(LocationCreateDTO locationWithPlanId) {
        Location locationToBeSaved = modelMapper.map(locationWithPlanId, Location.class);
        Location createdLocation=locationRepository.save(locationToBeSaved);
        locationRepository.updatePlanId(createdLocation.getId(), locationWithPlanId.getPlanId());
        return modelMapper.map(createdLocation, LocationWithTimeDTO.class);
    }

    @Override
    public LocationDTO updateLocation(long id, LocationDTO locationDTO) {
        Optional<Location> locationOptional = locationRepository.findById(id);

        if (locationOptional.isPresent()) {
            Location foundLoc = locationOptional.get();
            foundLoc.setName(locationDTO.getName());
            foundLoc.setDescription(locationDTO.getDescription());
            foundLoc.setCapacity(locationDTO.getCapacity());
//            foundLoc.setLocationType(locationDTO.getLocationType());
            return modelMapper.map(locationRepository.save(foundLoc), LocationDTO.class);
        }else {
            throw new ResourceNotFoundException("Location not found" + id);
        }
    }

    @Override
    public String deleteLocation(long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isPresent()) {
            locationRepository.deleteById(id);
            return "Location deleted";
        } else {
            throw new ResourceNotFoundException("Location not found" + id);
        }
    }
    @Override
    public LocationWithTimeDTO getLocation(long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if(locationOptional.isPresent()){
            return modelMapper.map(locationOptional.get(), LocationWithTimeDTO.class);
        }else{
            throw new ResourceNotFoundException("Location not found " + id);
        }
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(location -> modelMapper.map(location, LocationDTO.class))
                .collect(Collectors.toList());
    }
}
