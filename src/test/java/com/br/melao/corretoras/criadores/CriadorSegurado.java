package com.br.melao.corretoras.criadores;

import br.com.melao.corretora.model.Segurado;

public class CriadorSegurado {
	
	
	
	private Segurado segurado;

	public CriadorSegurado() {
		segurado = new Segurado();
	}

	public CriadorSegurado comCpf(String cpf) {
		segurado.setCpf(cpf);
		return this;
	}

	public CriadorSegurado comEmail(String email) {
		segurado.setEmail(email);
		return this;
	}

	public Segurado criar() {
		return segurado;
	}

}
