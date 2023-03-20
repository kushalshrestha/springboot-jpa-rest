package id_authentication.service.impl;

import id_authentication.domain.Location;
import id_authentication.dto.LocationDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.repositories.LocationRepository;
import id_authentication.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LocationDTO addLocation(LocationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO, Location.class);
        return modelMapper.map(locationRepository.save(location), LocationDTO.class);
    }

    @Override
    public LocationDTO updateLocation(long id, LocationDTO locationDTO) {
        Optional<Location> locationOptional = locationRepository.findById(id);

        if (locationOptional.isPresent()) {
            Location foundLoc = locationOptional.get();
            foundLoc.setName(locationDTO.getName());
            foundLoc.setDescription(locationDTO.getDescription());
            foundLoc.setCapacity(locationDTO.getCapacity());
            foundLoc.setLocationType(locationDTO.getLocationType());
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
    public LocationDTO getLocation(long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if(locationOptional.isPresent()){
            return modelMapper.map(locationOptional.get(), LocationDTO.class);
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
