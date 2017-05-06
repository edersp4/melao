package br.com.melao.corretora.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Seguro Aluguel")
public class ItemSeguroAluguel extends ItemSeguro {

	@Embedded
	private Endereco endereco;
	private String valorAluguel;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(String valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

}
