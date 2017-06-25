package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroConsorcio;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroConsorcioService;

@Controller
public class ItemSeguroConsorcioController extends ItemController {

	private Segurado segurado;

	@Autowired
	private ItemSeguroConsorcioService service;

	public ItemSeguroConsorcioController() {
	}

	@RequestMapping(value = "/item/cadastro-seguroConsorcio")
	public ModelAndView cadastro(ItemSeguroConsorcio itemSeguroConsorcio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroConsorcio");
		this.segurado = itemSeguroConsorcio.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroConsorcio")
	public ModelAndView gravar(ItemSeguroConsorcio itemSeguroConsorcio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroConsorcio");
		itemSeguroConsorcio.setSegurado(segurado);
		service.salvar(itemSeguroConsorcio);
		return view;
	}

}
