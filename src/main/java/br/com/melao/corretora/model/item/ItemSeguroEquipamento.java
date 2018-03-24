package br.com.melao.corretora.model.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Seguro Equipamento")
public class ItemSeguroEquipamento extends ItemSeguro {
	
	private String tipo;
	private String capitalSegurado;

}
