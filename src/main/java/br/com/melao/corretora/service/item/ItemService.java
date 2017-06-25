package br.com.melao.corretora.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.repository.comum.CiaSeguradoraRepository;
import br.com.melao.corretora.repository.segurado.SeguradoRepository;

@Service
public class ItemService {

	@Autowired
	private CiaSeguradoraRepository ciaSeguradoraRepository;
	
	@Autowired
	private SeguradoRepository seguradoRepository;

	public ItemService() {
	}

	public List<CiaSeguro> carregarSeguradora() {
		return ciaSeguradoraRepository.findAllByOrderByNomeAsc();
	}
	
	
	public List<Segurado> carregarSegurado() {
		return seguradoRepository.findAllByOrderByNomeAsc();
	}

}
