package id_authentication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication


@EnableJpaRepositories("id_authentication.repositories")

@EntityScan("id_authentication.domain")

public class IdAuthenticationApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(IdAuthenticationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}

