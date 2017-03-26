package br.com.melao.corretora.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.repository.SeguradoRepository;

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

	public Iterable<Segurado> buscarPorNome(Segurado segurado) {
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
				.withStringMatcher(StringMatcher.CONTAINING);
		
		Iterable<Segurado> listaSegurados = seguradoRepository.findAll(Example.of(segurado, exampleMatcher));
		
		return listaSegurados;
	}
	
	
	public Segurado detalheSegurado(Long id) {
		return seguradoRepository.findOne(id);
	}

}
