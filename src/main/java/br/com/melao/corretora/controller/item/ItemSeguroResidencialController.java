package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroResidencial;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroResidencialService;

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
