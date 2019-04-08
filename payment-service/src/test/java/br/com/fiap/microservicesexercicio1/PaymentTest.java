package br.com.fiap.microservicesexercicio1;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.fiap.payment.PaymentSpringBootApplication;
import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.service.PaymentService;

@RunWith(SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = PaymentSpringBootApplication.class)
public class PaymentTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mockMvc;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

    @Mock
    private PaymentService paymentService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(paymentService.save(any(PaymentDTO.class))).thenReturn(new PaymentDTO());
    }
    
 	@Test
 	public void naoAchouNadaTest() throws Exception {
 		mockMvc.perform(get("/payment/2")).andExpect(status().isNotFound());
 	}
    
    @Test
    public void salvarPagamnetoTest() {
        Assert.assertNotNull(paymentService.save(new PaymentDTO()));
    }
    


}