package br.com.melao.corretora.testes.utils;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import br.com.melao.corretora.criadores.CriadorSegurado;

import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.utils.ReflectionUtils;

public class ReflectionUtilsTest {

	
	@Test
	public void comCampoEmBranco() {

		CriadorSegurado criadorSegurado = new CriadorSegurado();
		Segurado segurado = criadorSegurado.comCpf("").comEmail("").criar();
		
		ReflectionUtils.nullifyStrings(segurado);
		
		assertThat(segurado.getCpf() ,nullValue() );
		assertThat(segurado.getEmail() ,nullValue() );
		
	}
	
	@Test
	public void comUmCampoNaoVazio() {
		CriadorSegurado criadorSegurado = new CriadorSegurado();
		Segurado segurado = criadorSegurado.comCpf("444").comEmail("").criar();
		
		ReflectionUtils.nullifyStrings(segurado);
		
		assertThat(segurado.getCpf() ,not(nullValue()));
		assertThat(segurado.getEmail() ,nullValue() );
		
		
		
	}
	

}
