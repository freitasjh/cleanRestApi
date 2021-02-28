package br.com.systec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.systec.model.ParametrosCalculoPrevisto;
import br.com.systec.model.RetornoCalculoPrevisto;
import br.com.systec.model.Veiculo;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class CalculoPrevistoTest {
	
	@Test
	public void testaCalculoPrevisao() {
		ParametrosCalculoPrevisto parametros = FabricaDeObjectoFake.parametroFake();
		Veiculo veiculo = FabricaDeObjectoFake.criaDadosFakeVeiculo();
		
		veiculo.setDataFabricacao(LocalDate.now());
		
		RetornoCalculoPrevisto retorno = new ModelMapper().map(veiculo, RetornoCalculoPrevisto.class).calculaQuantidadeCombustivelGasto(parametros, veiculo);
		
		assertEquals(BigDecimal.valueOf(66.52), retorno.getValoTotalGastoCombustivel());
		assertEquals(BigDecimal.valueOf(13.33), retorno.getQuantidadeCombustivelGasto());
		
	}
	
}
