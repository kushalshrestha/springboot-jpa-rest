package id_authentication;
import id_authentication.domain.Location;
import id_authentication.domain.LocationTimeSlot;
import id_authentication.repositories.PlanRepository;
import id_authentication.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IdAuthenticationApplication{
	public static void main(String[] args) {
		SpringApplication.run(IdAuthenticationApplication.class, args);
	}

}
