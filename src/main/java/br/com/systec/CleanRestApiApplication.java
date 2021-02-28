package br.com.systec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.systec.model.Veiculo;
import br.com.systec.service.VeiculoService;

@SpringBootApplication

public class CleanRestApiApplication implements CommandLineRunner{
	
	@Autowired
	private VeiculoService veiculoService;
	
	public static void main(String[] args) {
		SpringApplication.run(CleanRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setNome("Veiculo 1");
		veiculo1.setConsumoMedioCidade(BigDecimal.valueOf(10.0));
		veiculo1.setConsumoMedioRodovia(BigDecimal.valueOf(12.0));
		veiculo1.setMarca("Ford");
		veiculo1.setModelo("Ka");
		veiculo1.setDataFabricacao(LocalDate.now());
		
		veiculoService.save(veiculo1);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setNome("Veiculo 2");
		veiculo2.setConsumoMedioCidade(BigDecimal.valueOf(9.0));
		veiculo2.setConsumoMedioRodovia(BigDecimal.valueOf(11.0));
		veiculo2.setMarca("Ford");
		veiculo2.setModelo("Fusion");
		veiculo2.setDataFabricacao(LocalDate.now());
		
		Veiculo veiculo3 = new Veiculo();
		veiculo3.setNome("Veiculo 3");
		veiculo3.setConsumoMedioCidade(BigDecimal.valueOf(12.0));
		veiculo3.setConsumoMedioRodovia(BigDecimal.valueOf(16.0));
		veiculo3.setMarca("Renault");
		veiculo3.setModelo("Sandero");
		veiculo3.setDataFabricacao(LocalDate.now());
		
		veiculoService.save(veiculo1);
		veiculoService.save(veiculo2);
		veiculoService.save(veiculo3);
	}
	
	

}
