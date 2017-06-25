package br.com.melao.corretora.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroCondominio;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroCondominioService;

@Controller
public class ItemSeguroCondominioController extends ItemController {

	private Segurado segurado;

	@Autowired
	private ItemSeguroCondominioService service;

	public ItemSeguroCondominioController() {
	}

	@RequestMapping(value = "/item/cadastro-seguroCondominio")
	public ModelAndView cadastro(ItemSeguroCondominio itemSeguroCondominio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCondominio");
		this.segurado = itemSeguroCondominio.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroCondominio")
	public ModelAndView gravar(ItemSeguroCondominio itemSeguroCondominio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCondominio");
		itemSeguroCondominio.setSegurado(segurado);
		service.salvar(itemSeguroCondominio);
		return view;
	}

}
