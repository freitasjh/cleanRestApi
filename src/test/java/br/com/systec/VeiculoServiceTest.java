package br.com.systec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.systec.model.Veiculo;
import br.com.systec.service.VeiculoService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class VeiculoServiceTest {
	
	@MockBean
	VeiculoService service;
	
	@Test
	public void salvaVeiculo() {
		
		Veiculo veiculo = FabricaDeObjectoFake.criaDadosFakeVeiculo();
		
		service.save(veiculo);
		
	}
	
}
