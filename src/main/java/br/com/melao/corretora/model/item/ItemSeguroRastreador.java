package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Automovel;

@Entity
@DiscriminatorValue("Seguro Rastreador")
public class ItemSeguroRastreador extends ItemSeguro{

	public ItemSeguroRastreador() {
	}

	@Embedded
	private Automovel automovel;

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
}
