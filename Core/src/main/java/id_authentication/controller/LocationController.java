package id_authentication.controller;

import id_authentication.dto.LocationDTO;
import id_authentication.exceptions.ResourceNotFoundException;
import id_authentication.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @PostMapping
    public ResponseEntity<?> addLocation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.addLocation(locationDTO), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getLocation(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(locationService.getLocation(id), HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable long id, @RequestBody LocationDTO locationDTO) {
        try {
            return new ResponseEntity<>(locationService.updateLocation(id, locationDTO), HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable long id) {
        try {
            return new ResponseEntity<>(locationService.deleteLocation(id), HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
