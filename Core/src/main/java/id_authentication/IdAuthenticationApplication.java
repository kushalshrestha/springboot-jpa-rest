package id_authentication;


import id_authentication.dto.MemberDTO;
import id_authentication.dto.PlanDTO;
import id_authentication.repositories.PlanRepository;
import id_authentication.service.LocationService;
import id_authentication.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication


@EnableJpaRepositories("id_authentication.repositories")

@EntityScan("id_authentication.domain")

public class IdAuthenticationApplication implements CommandLineRunner{
	@Autowired

	private PlanRepository planRepository;
	@Autowired
	private LocationService locationService;

	@Autowired

	private PlanService planService;

	public static void main(String[] args) {
		SpringApplication.run(IdAuthenticationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		MemberDTO memberDTO = new MemberDTO(65132L,"gsgg","gfs",null,null,"tewtew,","tewe");
////		System.out.println(planService.createPlanForMember(new PlanDTO(213321L,"nvgnv",null,null,null)));
////		System.out.println(planRepository.findPlanByMembership_id(2L));
//		System.out.println("fdssdf"+planService.getPlansForMemberById(2L));
////		planService.deletePlanForMember(3L);
//		PlanDTO planDTO = new PlanDTO(3123L,"4324","543",null,null);
//		System.out.println(planService.updatePlanForMember(213321L,planDTO));
//		System.out.println("fdssdf"+planService.getPlansForMemberById(2L));
	}
}

