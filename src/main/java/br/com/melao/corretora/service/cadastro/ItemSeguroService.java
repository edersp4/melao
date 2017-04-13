package br.com.melao.corretora.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.ItemSeguroCarro;
import br.com.melao.corretora.repository.ItemSeguroRepository;

@Service
public class ItemSeguroService {
	@Autowired
	private ItemSeguroRepository repository;
	
	public void salvar(ItemSeguroCarro item) {
		repository.save(item);
	}
	
	
}
