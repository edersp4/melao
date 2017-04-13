package br.com.melao.corretora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.ItemSeguroCarro;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroService;

@Controller
public class ItemSeguradoController {
	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroService service;
	
	@RequestMapping(value = "/item/cadastro-seguroCarro")
	public ModelAndView cadastro(ItemSeguroCarro itemSeguroCarro) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCarro");
		this.segurado = itemSeguroCarro.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar")
	public ModelAndView gravar(ItemSeguroCarro itemSeguroCarro ) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCarro");
		itemSeguroCarro.setSegurado(segurado);
		service.salvar(itemSeguroCarro);
		System.out.println();
		return view;
	}

}
