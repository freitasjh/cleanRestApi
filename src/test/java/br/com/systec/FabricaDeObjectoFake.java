package br.com.systec;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.systec.model.ParametrosCalculoPrevisto;
import br.com.systec.model.Veiculo;


public class FabricaDeObjectoFake {
	
	public static Veiculo criaDadosFakeVeiculo() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setNome("Veiculo 1");
		veiculo.setConsumoMedioCidade(BigDecimal.valueOf(10.0));
		veiculo.setConsumoMedioRodovia(BigDecimal.valueOf(12.0));
		veiculo.setMarca("Ford");
		veiculo.setModelo("Ka");
//		veiculo.setDataFabricacao(LocalDate.now());
		
		return veiculo;
	}
	
	public static List<Veiculo> listaFakeDeVeiculos(){
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setId(1L);
		veiculo1.setNome("Veiculo 1");
		veiculo1.setConsumoMedioCidade(BigDecimal.valueOf(10.0));
		veiculo1.setConsumoMedioRodovia(BigDecimal.valueOf(12.0));
		veiculo1.setMarca("Ford");
		veiculo1.setModelo("Ka");
		veiculo1.setDataFabricacao(LocalDate.now());
		
		Veiculo veiculo2 = new Veiculo();
		veiculo1.setId(2L);
		veiculo2.setNome("Veiculo 2");
		veiculo2.setConsumoMedioCidade(BigDecimal.valueOf(9.0));
		veiculo2.setConsumoMedioRodovia(BigDecimal.valueOf(11.0));
		veiculo2.setMarca("Ford");
		veiculo2.setModelo("Fusion");
		veiculo2.setDataFabricacao(LocalDate.now());
		
		Veiculo veiculo3 = new Veiculo();
		veiculo1.setId(3L);
		veiculo3.setNome("Veiculo 3");
		veiculo3.setConsumoMedioCidade(BigDecimal.valueOf(12.0));
		veiculo3.setConsumoMedioRodovia(BigDecimal.valueOf(16.0));
		veiculo3.setMarca("Renault");
		veiculo3.setModelo("Sandero");
		veiculo3.setDataFabricacao(LocalDate.now());
		
		return java.util.Arrays.asList(veiculo1,veiculo2,veiculo3);
	}
	
	public static ParametrosCalculoPrevisto parametroFake() {
		ParametrosCalculoPrevisto parametro = new ParametrosCalculoPrevisto();
		parametro.setKmCidade(BigDecimal.valueOf(50));
		parametro.setKmRodovia(BigDecimal.valueOf(100));
		parametro.setPrecoGasolina(BigDecimal.valueOf(4.99));
		
		return parametro;
	}
	
}
