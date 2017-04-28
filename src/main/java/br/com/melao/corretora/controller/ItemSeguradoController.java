package br.com.melao.corretora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.ItemSeguroCarro;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroService;
import org.springframework.validation.BindingResult; 

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
	public ModelAndView gravar(@Valid ItemSeguroCarro itemSeguroCarro, BindingResult result ) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCarro");
		itemSeguroCarro.setSegurado(segurado);
		
		if(result.hasErrors()) {
			return cadastro(itemSeguroCarro);
		}
		service.salvar(itemSeguroCarro);
		return view;
	}

}
