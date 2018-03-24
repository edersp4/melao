package br.com.melao.corretora.model.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import br.com.melao.corretora.model.comum.Endereco;
import lombok.*;

@Data
@Entity
@DiscriminatorValue( "Seguro Condominio")
public class ItemSeguroCondominio extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	private String coberturaBasica;

}
