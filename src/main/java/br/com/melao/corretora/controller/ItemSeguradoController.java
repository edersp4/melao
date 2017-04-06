package br.com.melao.corretora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.ItemSeguroCarro;

@Controller
public class ItemSeguradoController {
	
	@RequestMapping(value="/item/cadastro-seguroCarro")
	public ModelAndView cadastro(ItemSeguroCarro itemSeguroCarro ) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCarro");
		return view;
	}

	@RequestMapping(value="/item/gravar" , method=RequestMethod.POST)
	public ModelAndView gravar(ItemSeguroCarro itemSeguroCarro) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCarro");
		return view;
	}
	
	
}
