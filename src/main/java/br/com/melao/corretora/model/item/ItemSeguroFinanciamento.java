package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Automovel;
import br.com.melao.corretora.model.comum.Endereco;

@Entity
@DiscriminatorValue( "Seguro Financiamento")
public class ItemSeguroFinanciamento extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Automovel automovel;

	private String tipo;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	
}
