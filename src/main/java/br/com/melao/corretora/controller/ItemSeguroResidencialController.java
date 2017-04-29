package br.com.melao.corretora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroResidencial;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroResidencialService;

@Controller
public class ItemSeguroResidencialController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroResidencialService service;
	
	public ItemSeguroResidencialController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroResidencial")
	public ModelAndView cadastro(ItemSeguroResidencial itemSeguroResidencial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroResidencial");
		this.segurado = itemSeguroResidencial.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroResidencial")
	public ModelAndView gravar(ItemSeguroResidencial itemSeguroResidencial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroResidencial");
		itemSeguroResidencial.setSegurado(segurado);
		service.salvar(itemSeguroResidencial);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
