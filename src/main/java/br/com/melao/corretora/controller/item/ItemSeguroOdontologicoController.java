package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroOdontologico;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroOdontologicoService;

@Controller
public class ItemSeguroOdontologicoController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroOdontologicoService service;
	
	public ItemSeguroOdontologicoController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroOdontologico")
	public ModelAndView cadastro(ItemSeguroOdontologico itemSeguroOdontologico) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroOdontologico");
		this.segurado = itemSeguroOdontologico.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroOdontologico")
	public ModelAndView gravar(ItemSeguroOdontologico itemSeguroOdontologico) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroOdontologico");
		itemSeguroOdontologico.setSegurado(segurado);
		service.salvar(itemSeguroOdontologico);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
