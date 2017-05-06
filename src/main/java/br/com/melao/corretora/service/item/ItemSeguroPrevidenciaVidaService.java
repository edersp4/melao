package br.com.melao.corretora.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroPrevidencia;
import br.com.melao.corretora.repository.comum.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.item.ItemSeguroPrevidenciaRepository;

@Service
public class ItemSeguroPrevidenciaVidaService {

	@Autowired
	private ItemSeguroPrevidenciaRepository repository;
	
	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	
	public void salvar(ItemSeguroPrevidencia itemSeguroPrevidencia) {
		repository.save(itemSeguroPrevidencia);
	}
	
	public List<CiaSeguro> carregarSeguradora(){
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	

}
