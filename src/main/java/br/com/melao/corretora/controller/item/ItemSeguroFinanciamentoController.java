package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroFinanciamento;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroFinanciamentoService;

@Controller
public class ItemSeguroFinanciamentoController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroFinanciamentoService service;
	
	public ItemSeguroFinanciamentoController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroFinanciamento")
	public ModelAndView cadastro(ItemSeguroFinanciamento itemSeguroFinanciamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroFinanciamento");
		this.segurado = itemSeguroFinanciamento.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroFinanciamento")
	public ModelAndView gravar(ItemSeguroFinanciamento itemSeguroFinanciamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroFinanciamento");
		itemSeguroFinanciamento.setSegurado(segurado);
		service.salvar(itemSeguroFinanciamento);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
