package id_authentication;


import id_authentication.service.PlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PlanService planService;


    @Test

    public void testGetPlanById()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/plans/{id}",1)).andExpect(status().isOk());

        verify(planService,times(1)).deletePlanForMember(1L);
    }

}
