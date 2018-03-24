package br.com.melao.corretora.model.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Seguro Odontologico")
public class ItemSeguroOdontologico extends ItemSeguro {

	private String tipo;
	private String operadora;

}
