package br.com.melao.corretora.service.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroEmpresarial;
import br.com.melao.corretora.repository.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.ItemSeguroEmpresarialRepository;

@Service
public class ItemSeguroEmpresarialService {
	@Autowired
	private ItemSeguroEmpresarialRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	public void salvar(ItemSeguroEmpresarial item) {
		repository.save(item);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	
}