package br.com.melao.corretora.model.item;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Data
@Entity
@DiscriminatorValue("Seguro Previdência")
public class ItemSeguroPrevidencia extends ItemSeguro {

	private String tipo;

	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal capitalSegurado;

}
