package client.restTemplate;

import client.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class MemberTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Value("${serverurl}")
    String serverURL;
    HttpHeaders headers ;
    @PostConstruct
    public void init(){
        headers = new HttpHeaders();
        headers.setBasicAuth("username", "password");
    }

    public MemberDTO getMember(String userName, String password){
        MemberDTO memberDTO = new MemberDTO(userName,password);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MemberDTO> requestEntity = new HttpEntity<>(memberDTO,headers);
        ResponseEntity<MemberDTO> response = restTemplate.postForEntity(serverURL + "/members/authentication"
                , requestEntity, MemberDTO.class);

        MemberDTO responseObj = response.getBody();
        return responseObj;
                //restTemplate.postForObject(serverURL + "/members/authentication",new MemberDTO(userName,password),MemberDTO.class);

    }



}
