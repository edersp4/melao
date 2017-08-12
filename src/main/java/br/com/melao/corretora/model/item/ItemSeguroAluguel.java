package br.com.melao.corretora.model.item;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.springframework.format.annotation.NumberFormat;

import br.com.melao.corretora.model.comum.Endereco;

@Entity
@DiscriminatorValue("Seguro Aluguel")
public class ItemSeguroAluguel extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorAluguel;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	
}
