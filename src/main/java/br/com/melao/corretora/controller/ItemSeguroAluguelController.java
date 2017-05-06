package br.com.melao.corretora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroAluguel;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroAluguelService;

@Controller
public class ItemSeguroAluguelController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroAluguelService service;
	
	public ItemSeguroAluguelController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroAluguel")
	public ModelAndView cadastro(ItemSeguroAluguel itemSeguroAluguel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAluguel");
		this.segurado = itemSeguroAluguel.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroAluguel")
	public ModelAndView gravar(ItemSeguroAluguel itemSeguroAluguel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAluguel");
		itemSeguroAluguel.setSegurado(segurado);
		service.salvar(itemSeguroAluguel);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
