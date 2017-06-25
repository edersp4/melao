package br.com.melao.corretora.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.item.ItemSeguroAluguel;
import br.com.melao.corretora.repository.item.ItemSeguroAluguelRepository;

@Service
public class ItemSeguroAluguelService {
	@Autowired
	private ItemSeguroAluguelRepository repository;
	
	
	
	public void salvar(ItemSeguroAluguel item) {
		repository.save(item);
	}
	
	
	
}
