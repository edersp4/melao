package br.com.melao.corretora.model.item;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.format.annotation.NumberFormat;

@Entity
@DiscriminatorValue("Seguro Previdência")
public class ItemSeguroPrevidencia extends ItemSeguro {

	private String tipo;

	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal capitalSegurado;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getCapitalSegurado() {
		return capitalSegurado;
	}

	public void setCapitalSegurado(BigDecimal capitalSegurado) {
		this.capitalSegurado = capitalSegurado;
	}

}
