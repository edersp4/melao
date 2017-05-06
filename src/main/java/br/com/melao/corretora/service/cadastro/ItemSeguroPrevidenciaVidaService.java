package br.com.melao.corretora.service.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroPrevidencia;
import br.com.melao.corretora.model.ItemSeguroVida;
import br.com.melao.corretora.repository.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.ItemSeguroPrevidenciaRepository;
import br.com.melao.corretora.repository.ItemSeguroVidaRepository;

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
