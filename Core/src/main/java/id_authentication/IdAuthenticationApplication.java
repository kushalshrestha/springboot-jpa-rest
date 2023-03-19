package id_authentication;

import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
import id_authentication.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class IdAuthenticationApplication implements CommandLineRunner {
	@Autowired
	private LocationService locationService;
	public static void main(String[] args) {
		SpringApplication.run(IdAuthenticationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		LocationTimeSlot locationTimeSlot = new LocationTimeSlot( 1,LocalDateTime.now(),LocalDateTime.now().plusHours(1));
		List<LocationTimeSlot> locationTimeSlots =new ArrayList<LocationTimeSlot>();
		Location location = new Location("Argiro","",100,"DINING_HALL",locationTimeSlots);
		locationService.addLocation(location);
	}
}
