package br.com.melao.corretora.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroAutomovel;
import br.com.melao.corretora.repository.comum.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.item.ItemSeguroAutomovelRepository;

@Service
public class ItemSeguroAutomovelService {
	@Autowired
	private ItemSeguroAutomovelRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	public void salvar(ItemSeguroAutomovel item) {
		repository.save(item);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	
}
