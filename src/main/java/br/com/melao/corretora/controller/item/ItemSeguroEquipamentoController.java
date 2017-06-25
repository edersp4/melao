package br.com.melao.corretora.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroEquipamento;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroEquipamentoService;

@Controller
public class ItemSeguroEquipamentoController extends ItemController {

	private Segurado segurado;

	@Autowired
	private ItemSeguroEquipamentoService service;

	public ItemSeguroEquipamentoController() {
	}

	@RequestMapping(value = "/item/cadastro-seguroEquipamento")
	public ModelAndView cadastro(ItemSeguroEquipamento itemSeguroEquipamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEquipamento");
		this.segurado = itemSeguroEquipamento.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroEquipamento")
	public ModelAndView gravar(ItemSeguroEquipamento itemSeguroEquipamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEquipamento");
		itemSeguroEquipamento.setSegurado(segurado);
		service.salvar(itemSeguroEquipamento);
		return view;
	}

}
