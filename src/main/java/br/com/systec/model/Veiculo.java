package br.com.systec.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "data_fabricacao")
	private LocalDate dataFabricacao;
	@Column(name = "consumo_medio_cidade")
	private BigDecimal consumoMedioCidade;
	@Column(name = "consumo_medio_rodovia")
	private BigDecimal consumoMedioRodovia;
	
	public Veiculo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public BigDecimal getConsumoMedioCidade() {
		return consumoMedioCidade;
	}

	public void setConsumoMedioCidade(BigDecimal consumoMedioCidade) {
		this.consumoMedioCidade = consumoMedioCidade;
	}

	public BigDecimal getConsumoMedioRodovia() {
		return consumoMedioRodovia;
	}

	public void setConsumoMedioRodovia(BigDecimal consumoMedioRodovia) {
		this.consumoMedioRodovia = consumoMedioRodovia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
