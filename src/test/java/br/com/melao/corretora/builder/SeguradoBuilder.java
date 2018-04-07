package br.com.melao.corretora.builder;

import br.com.melao.corretora.model.comum.Endereco;
import br.com.melao.corretora.model.item.ItemSeguro;
import br.com.melao.corretora.model.segurado.Segurado;

import java.util.Arrays;
import java.util.Calendar;


public class SeguradoBuilder {
	private Segurado elemento;
	private SeguradoBuilder(){}

	public static SeguradoBuilder umSegurado() {
		SeguradoBuilder builder = new SeguradoBuilder();
		inicializarDadosPadroes(builder);
		return builder;
	}

	public static void inicializarDadosPadroes(SeguradoBuilder builder) {
		builder.elemento = new Segurado();
		Segurado elemento = builder.elemento;

		
		elemento.setId(0L);
		elemento.setNome("");
		elemento.setCpf("");
		elemento.setTelefone("");
		elemento.setCelular("");
		elemento.setTelefoneTrab("");
		elemento.setEmail("");
		elemento.setCep("");
		elemento.setSeguro(null);
		elemento.setDataDeNascimento(null);
		elemento.setEndereco(null);
	}

	public SeguradoBuilder comId(Long param) {
		elemento.setId(param);
		return this;
	}

	public SeguradoBuilder comNome(String param) {
		elemento.setNome(param);
		return this;
	}

	public SeguradoBuilder comCpf(String param) {
		elemento.setCpf(param);
		return this;
	}

	public SeguradoBuilder comTelefone(String param) {
		elemento.setTelefone(param);
		return this;
	}

	public SeguradoBuilder comCelular(String param) {
		elemento.setCelular(param);
		return this;
	}

	public SeguradoBuilder comTelefoneTrab(String param) {
		elemento.setTelefoneTrab(param);
		return this;
	}

	public SeguradoBuilder comEmail(String param) {
		elemento.setEmail(param);
		return this;
	}

	public SeguradoBuilder comCep(String param) {
		elemento.setCep(param);
		return this;
	}

	public SeguradoBuilder comListaSeguro(ItemSeguro... params) {
		elemento.setSeguro(Arrays.asList(params));
		return this;
	}

	public SeguradoBuilder comDataDeNascimento(Calendar param) {
		elemento.setDataDeNascimento(param);
		return this;
	}

	public SeguradoBuilder comEndereco(Endereco param) {
		elemento.setEndereco(param);
		return this;
	}

	public Segurado agora() {
		return elemento;
	}
}
