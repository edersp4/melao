package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroVida;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroVidaService;

@Controller
public class ItemSeguroVidaController {

	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroVidaService service;
	
	public ItemSeguroVidaController() {
	}
	
	
	@RequestMapping(value = "/item/cadastro-seguroVida")
	public ModelAndView cadastro(ItemSeguroVida itemSeguroVida) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroVida");
		this.segurado = itemSeguroVida.getSegurado();
		return view;
	}
	
	@RequestMapping(value = "/item/gravar-seguroVida")
	public ModelAndView gravar(ItemSeguroVida itemSeguroVida) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroVida");
		itemSeguroVida.setSegurado(segurado);
		service.salvar(itemSeguroVida);
		return view;
	}
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
