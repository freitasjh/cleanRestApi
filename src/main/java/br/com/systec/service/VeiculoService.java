package br.com.systec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.model.Veiculo;
import br.com.systec.repository.VeiculoRepository;
import br.com.systec.service.exceptions.ObjectNotFoundException;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	public List<Veiculo> findAll(){
		return repository.findAll();
	}
	
	public Veiculo findById(Long id) {
		return ((Optional<Veiculo>) repository.findById(id)).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Veiculo save(Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
}
