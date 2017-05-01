package br.com.melao.corretora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroEmpresarial;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroEmpresarialService;

@Controller
public class ItemSeguroEmpresarialController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroEmpresarialService service;
	
	public ItemSeguroEmpresarialController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroEmpresarial")
	public ModelAndView cadastro(ItemSeguroEmpresarial itemSeguroEmpresarial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEmpresarial");
		this.segurado = itemSeguroEmpresarial.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroEmpresarial")
	public ModelAndView gravar(ItemSeguroEmpresarial itemSeguroEmpresarial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEmpresarial");
		itemSeguroEmpresarial.setSegurado(segurado);
		service.salvar(itemSeguroEmpresarial);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
