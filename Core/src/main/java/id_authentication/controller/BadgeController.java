package id_authentication.controller;
import id_authentication.domain.Badge;
import id_authentication.dto.BadgeDTO;
import id_authentication.errorhandler.CustomErrorType;
import id_authentication.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/badge")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    private Map<String, BadgeDTO> badges= new HashMap<>();

    public BadgeController (){
        badges.put(123, new BadgeDTO("B001", 05/30/2023, "ACTIVE", "M001", "001") );
        badges.put(124, new BadgeDTO("B002", 05/30/2024, "ACTIVE", "M002", "002") );

    }
    @GetMapping("/badges/{badgeNumber}")
    public ResponseEntity<?> getBadge(@PathVariable String badgeNumber) {
        BadgeDTO badge = badges.get(badgeNumber);
        if (badge == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Badge Not Found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Badge>(badge, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBadges(){
        return new ResponseEntity<>(badgeService.getAllBadges(), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?> createBadges(@RequestBody BadgeDTO badgeDTO){
        return new ResponseEntity<>(badgeService.createBadge(badgeDTO), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBadge(@PathVariable Long badgeNumber, @RequestBody BadgeDTO badgeDTO){
        try {
            return new ResponseEntity<>(badgeService.updateBadge(badgeNumber, badgeDTO), HttpStatus.OK);
        }catch(CustomErrorType e){
        return new ResponseEntity<>(new CustomErrorType(e.getErrorMessage()), HttpStatus.NOT_FOUND);
        }

    }
}
