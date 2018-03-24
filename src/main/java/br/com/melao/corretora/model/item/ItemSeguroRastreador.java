package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Automovel;
import lombok.*;

@Data
@Entity
@DiscriminatorValue("Seguro Rastreador")
public class ItemSeguroRastreador extends ItemSeguro{

	public ItemSeguroRastreador() {
	}

	@Embedded
	private Automovel automovel;

}
