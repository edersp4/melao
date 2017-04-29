package br.com.melao.corretora.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;


@Entity
@DiscriminatorColumn(name="Seguro Residencial")
public class ItemSeguroResidencial extends ItemSeguro {
	
	@Embedded
	private Endereco endereco;
	private String coberturaBasica;
	
	
}
