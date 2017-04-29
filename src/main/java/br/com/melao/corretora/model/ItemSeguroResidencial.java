package br.com.melao.corretora.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "Seguro Residencial")
public class ItemSeguroResidencial extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	private String coberturaBasica;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCoberturaBasica() {
		return coberturaBasica;
	}

	public void setCoberturaBasica(String coberturaBasica) {
		this.coberturaBasica = coberturaBasica;
	}

}
