package br.com.systec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.model.ParametrosCalculoPrevisto;
import br.com.systec.model.RetornoCalculoPrevisto;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Service
public class CalculoPrevistoService {
	
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<RetornoCalculoPrevisto> calculaPrecoPrevisto(ParametrosCalculoPrevisto parametrosCalculo){
		
		List<RetornoCalculoPrevisto> listaRanqueada = veiculoService.findAll().stream()
				.map(item -> modelMapper.map(item, RetornoCalculoPrevisto.class).calculaQuantidadeCombustivelGasto(parametrosCalculo, item))
				.collect(Collectors.toList());
		
		return listaRanqueada.stream().sorted((obj1, obj2) -> obj1.getValoTotalGastoCombustivel().compareTo(obj2.getValoTotalGastoCombustivel())).collect(Collectors.toList());
	}
}
