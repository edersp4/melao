package br.com.melao.corretora.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroResidencial;
import br.com.melao.corretora.repository.comum.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.item.ItemSeguroResidencialRepository;

@Service
public class ItemSeguroResidencialService {
	@Autowired
	private ItemSeguroResidencialRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	public void salvar(ItemSeguroResidencial item) {
		repository.save(item);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	
}
