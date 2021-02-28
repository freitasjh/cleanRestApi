package br.com.systec.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.model.Veiculo;
import br.com.systec.service.VeiculoService;
import io.swagger.annotations.Api;


/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Veiculo veiculo) {
		service.save(veiculo);
	}
	
}
