package br.com.melao.corretora.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Seguro Previdência")
public class ItemSeguroPrevidencia extends ItemSeguro {
	
	private String tipo;
	private String capitalSegurado;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCapitalSegurado() {
		return capitalSegurado;
	}

	public void setCapitalSegurado(String capitalSegurado) {
		this.capitalSegurado = capitalSegurado;
	}

}
