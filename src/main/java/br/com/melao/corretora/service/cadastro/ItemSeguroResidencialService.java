package br.com.melao.corretora.service.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroResidencial;
import br.com.melao.corretora.repository.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.ItemSeguroResidencialRepository;

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
