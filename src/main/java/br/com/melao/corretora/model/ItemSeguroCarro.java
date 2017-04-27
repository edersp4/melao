package br.com.melao.corretora.model;

import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("SeguroCarro")
public class ItemSeguroCarro extends ItemSeguro{

	public ItemSeguroCarro() {
	}

	private String modelo;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFabricacao;
	private String placa;
	private String chassi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="ID_SEGURADO" )
	private Segurado segurado;
	
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
	public Segurado getSegurado() {
		return segurado;
	}
	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao( Calendar dataFabricacao ) {
		this.dataFabricacao = dataFabricacao;
	}
}
