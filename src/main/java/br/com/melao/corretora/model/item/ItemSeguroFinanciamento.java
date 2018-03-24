package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Automovel;
import br.com.melao.corretora.model.comum.Endereco;
import lombok.*;

@Data
@Entity
@DiscriminatorValue( "Seguro Financiamento")
public class ItemSeguroFinanciamento extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Automovel automovel;

	private String tipo;


}
