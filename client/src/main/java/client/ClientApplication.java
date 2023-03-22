package client;

import client.dto.MemberDTO;
import client.restTemplate.MemberTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	@Autowired
	MemberTemplate memberTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MemberDTO memberDTO=memberTemplate.getMember("sriti.prajapati","test123");
		System.out.println(memberDTO);
	}
}
