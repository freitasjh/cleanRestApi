package br.com.systec.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class RetornoCalculoPrevisto {

	private String nome;
	private String marca;
	private String modelo;
	private String ano;
	private BigDecimal quantidadeCombustivelGasto;
	private BigDecimal valoTotalGastoCombustivel;

	public RetornoCalculoPrevisto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getQuantidadeCombustivelGasto() {
		return quantidadeCombustivelGasto;
	}

	public void setQuantidadeCombustivelGasto(BigDecimal quantidadeCombustivelGasto) {
		this.quantidadeCombustivelGasto = quantidadeCombustivelGasto;
	}

	public BigDecimal getValoTotalGastoCombustivel() {
		return valoTotalGastoCombustivel;
	}

	public void setValoTotalGastoCombustivel(BigDecimal valoTotalGastoCombustivel) {
		this.valoTotalGastoCombustivel = valoTotalGastoCombustivel;
	}
	
	public RetornoCalculoPrevisto calculaQuantidadeCombustivelGasto(final ParametrosCalculoPrevisto parametrosCalculo, final Veiculo veiculo) {
		BigDecimal litrosGastoCidade = parametrosCalculo.getKmCidade().divide(veiculo.getConsumoMedioCidade(), 2, RoundingMode.HALF_EVEN);
		BigDecimal litrosGastoRodovia = parametrosCalculo.getKmRodovia().divide(veiculo.getConsumoMedioRodovia(),2, RoundingMode.HALF_EVEN);
		
		this.quantidadeCombustivelGasto = litrosGastoRodovia.add(litrosGastoCidade);
		this.valoTotalGastoCombustivel = this.quantidadeCombustivelGasto.multiply(parametrosCalculo.getPrecoGasolina()).setScale(2, RoundingMode.HALF_EVEN);
		this.ano = veiculo.getDataFabricacao().format(DateTimeFormatter.ofPattern("yyyy"));
		
		return this;
	}
	

}
