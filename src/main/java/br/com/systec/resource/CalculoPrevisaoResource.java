package br.com.systec.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.model.ParametrosCalculoPrevisto;
import br.com.systec.model.RetornoCalculoPrevisto;
import br.com.systec.service.CalculoPrevistoService;
import io.swagger.annotations.Api;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@RestController
@RequestMapping("/calculoPrevisao")
@Api("Calculo Previsão")
public class CalculoPrevisaoResource {
	
	@Autowired
	private CalculoPrevistoService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<RetornoCalculoPrevisto>> calculaAPrevisaoDeGasto(@Valid @RequestBody ParametrosCalculoPrevisto parametrosCalculo){
		return ResponseEntity.ok(service.calculaPrecoPrevisto(parametrosCalculo));
	}
	
}
