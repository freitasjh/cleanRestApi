package br.com.systec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.systec.model.Veiculo;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
