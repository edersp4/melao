package br.com.melao.corretora.model.comum;

import lombok.*;

import javax.persistence.Embeddable;


@Embeddable
@Data
public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String complemento;
	private String estado;
	
	
	private String cep;


}
