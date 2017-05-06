package br.com.melao.corretora.service.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroAluguel;
import br.com.melao.corretora.repository.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.ItemSeguroAluguelRepository;

@Service
public class ItemSeguroAluguelService {
	@Autowired
	private ItemSeguroAluguelRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	public void salvar(ItemSeguroAluguel item) {
		repository.save(item);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	
}
