package br.com.melao.corretora.model.comum;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Automovel {

	private String modelo;
	private String dataFabricacao;
	private String placa;
	private String chassi;


}
