package br.com.melao.corretora.service.segurado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.repository.segurado.SeguradoRepository;
import br.com.melao.corretora.utils.ReflectionUtils;

@Service
public class SeguradoService {

	@Autowired
	private SeguradoRepository seguradoRepository;
	

	public void gravarUsuarioOuAtualizar(Segurado segurado) {
		seguradoRepository.save(segurado);
	}

	public Iterable<Segurado> listar() {
		Iterable<Segurado> listaDeSegurados = seguradoRepository.findAll();
		return listaDeSegurados;
	}

	public Iterable<Segurado> buscarPorExemplo(Segurado segurado) {
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(StringMatcher.CONTAINING);
		
		ReflectionUtils.nullifyStrings(segurado);
		Iterable<Segurado> listaSegurados = seguradoRepository.findAll(Example.of(segurado, exampleMatcher));
		return listaSegurados;
	}
	
	
	public Segurado detalheSegurado(Long id) {
		return seguradoRepository.getOne(id);
	}

}
