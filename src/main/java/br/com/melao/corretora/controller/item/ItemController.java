package br.com.melao.corretora.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemService;
import br.com.melao.corretora.service.segurado.SeguradoService;
import br.com.melao.corretora.utils.ReflectionUtils;

@Controller
public abstract class ItemController {

	@Autowired
	private ItemService service;
	
	
	protected Segurado segurado;
	
	@Autowired
	private SeguradoService seguradoService;

	public ItemController() {
	}

	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora() {
		return service.carregarSeguradora();
	}
	
	@ModelAttribute("listaSegurado")
	public List<String> popularSegurado() {
		List<String> listaSegCPF = new ArrayList<>();
		
		
		for (Segurado segurado :  service.carregarSegurado()) {
			listaSegCPF.add(segurado.getCpf() + " - " + segurado.getNome());
		}
		
		return listaSegCPF;
	}
	
	
	protected void selecionarSegurado(String seguradoNomeCPF) {
		String[] informacaoSegurado = seguradoNomeCPF.split(" - ");
		String nome = "";
		String cpf = "";
		
		if(informacaoSegurado.length == 2) {
			cpf = informacaoSegurado[0];
			nome = informacaoSegurado[1];
		}
		
		Segurado seguradoDTO = new Segurado();
		seguradoDTO.setCpf(cpf);
		seguradoDTO.setNome(nome);
		
		ReflectionUtils.nullifyStrings(seguradoDTO);
		List<Segurado> listaSegurados = (List<Segurado>) seguradoService.buscarPorExemplo(seguradoDTO);
		this.segurado = listaSegurados.get(0);
	}
	
	
	public abstract void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response);
	
	
}
