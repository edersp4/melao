package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Endereco;

@Entity
@DiscriminatorValue( "Seguro Consórcio")
public class ItemSeguroConsorcio extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	@Embedded
	private ItemSeguroAutomovel automovel;

	private String tipo;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ItemSeguroAutomovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(ItemSeguroAutomovel automovel) {
		this.automovel = automovel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
