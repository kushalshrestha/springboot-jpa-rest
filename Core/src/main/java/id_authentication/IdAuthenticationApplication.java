package id_authentication;

import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
<<<<<<< HEAD
=======
import id_authentication.repositories.PlanRepository;
>>>>>>> main
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
<<<<<<< HEAD
public class IdAuthenticationApplication{
=======
public class IdAuthenticationApplication implements CommandLineRunner{
>>>>>>> main
	@Autowired
	private LocationService locationService;
	public static void main(String[] args) {
		SpringApplication.run(IdAuthenticationApplication.class, args);
	}

	@Autowired

	private PlanRepository planRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(planRepository.getMemberPlansById(2L));
	}
}
