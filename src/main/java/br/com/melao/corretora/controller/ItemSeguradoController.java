package br.com.melao.corretora.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.CiaSeguro;
import br.com.melao.corretora.model.ItemSeguroAutomovel;
import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.ItemSeguroService;
import org.springframework.validation.BindingResult; 

@Controller
public class ItemSeguradoController {
	
	private Segurado segurado;
	
	@Autowired
	private ItemSeguroService service;
	
	@RequestMapping(value = "/item/cadastro-seguroAutomovel")
	public ModelAndView cadastro(ItemSeguroAutomovel itemSeguroAutomovel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAutomovel");
		this.segurado = itemSeguroAutomovel.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar")
	public ModelAndView gravar(@Valid ItemSeguroAutomovel itemSeguroCarro, BindingResult result ) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAutomovel");
		itemSeguroCarro.setSegurado(segurado);
		
		if(result.hasErrors()) {
			return cadastro(itemSeguroCarro);
		}
		service.salvar(itemSeguroCarro);
		return view;
	}
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}

}
