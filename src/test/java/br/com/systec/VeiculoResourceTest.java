package br.com.systec;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.systec.model.Veiculo;
import br.com.systec.service.CalculoPrevistoService;
import br.com.systec.service.VeiculoService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class VeiculoResourceTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VeiculoService veiculoService;
	
	@MockBean
	private CalculoPrevistoService service;
	
	@Test
	@DisplayName("Deve criar um veiculo de teste")
	public void createVeiculoTest() throws Exception{
		Veiculo veiculo = FabricaDeObjectoFake.criaDadosFakeVeiculo();
		String json = new ObjectMapper().writeValueAsString(veiculo);
		
		BDDMockito.given(veiculoService.save(Mockito.any(Veiculo.class))).willReturn(veiculo);
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("/veiculo")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);
		
		mvc.perform(request)
			.andExpect(status().isCreated());
	}
	
	@Test
	public void findAllVeiculoTest() throws Exception {
		
		BDDMockito.given(veiculoService.findAll()).willReturn(FabricaDeObjectoFake.listaFakeDeVeiculos());
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/veiculo")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(3)));
	
	}
	
	@Test
	public void findByIdVeiculoTest() throws Exception {
		Veiculo veiculo = FabricaDeObjectoFake.criaDadosFakeVeiculo();
		veiculo.setId(1L);
		
		BDDMockito.given(veiculoService.findById(1L)).willReturn(veiculo);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/veiculo/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(jsonPath("id", is(1)));
	
	}
	
	

	
}
