package br.com.melao.corretora.model.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("Seguro Vida")
public class ItemSeguroVida extends ItemSeguro {
	
	private String tipo;
	private String capitalSegurado;

}
