package br.com.melao.corretora.model.item;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import br.com.melao.corretora.model.comum.Endereco;

@Data
@Entity
@DiscriminatorValue("Seguro Aluguel")
public class ItemSeguroAluguel extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorAluguel;


}
