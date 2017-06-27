package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroOdontologico;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroOdontologicoService;

@Controller
public class ItemSeguroOdontologicoController extends ItemController {

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
	
	@RequestMapping(value="/item/odontologico/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
