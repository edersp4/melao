package br.com.melao.corretora.model.comum;

import javax.persistence.Embeddable;

@Embeddable
public class Automovel {

	public Automovel() {
		
	}
	
	
	private String modelo;
	private String dataFabricacao;
	private String placa;
	private String chassi;
	
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}


}
