package br.com.melao.corretora.service.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroAutomovel;
import br.com.melao.corretora.repository.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.ItemSeguroRepository;

@Service
public class ItemSeguroService {
	@Autowired
	private ItemSeguroRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	public void salvar(ItemSeguroAutomovel item) {
		repository.save(item);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAll();
	}
	
	
}
