package br.com.systec.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class ParametrosCalculoPrevisto {
	
	@NotNull(message = "Informe o preço da gasolina")
	@DecimalMin(value = "0.1", inclusive = false, message = "Informe o preço da gasolina")
	private BigDecimal precoGasolina;
	@NotNull(message = "Infome quantos KM foram percorrido na cidade")
	@DecimalMin(value = "0.1", inclusive = false, message = "Infome quantos KM foram percorrido na cidade")
	private BigDecimal kmCidade;
	@NotNull(message ="Infome quantos KM foram percorrido na rodovia")
	@DecimalMin(value = "0.1", inclusive = false, message ="Infome quantos KM foram percorrido na rodovia")
	private BigDecimal kmRodovia;
	
	public ParametrosCalculoPrevisto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal getPrecoGasolina() {
		return precoGasolina;
	}

	public void setPrecoGasolina(BigDecimal precoGasolina) {
		this.precoGasolina = precoGasolina;
	}

	public BigDecimal getKmCidade() {
		return kmCidade;
	}

	public void setKmCidade(BigDecimal kmCidade) {
		this.kmCidade = kmCidade;
	}

	public BigDecimal getKmRodovia() {
		return kmRodovia;
	}

	public void setKmRodovia(BigDecimal kmRodovia) {
		this.kmRodovia = kmRodovia;
	}



}
