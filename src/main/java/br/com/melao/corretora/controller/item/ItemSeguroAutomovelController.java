package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroAutomovel;
import br.com.melao.corretora.service.item.ItemSeguroAutomovelService; 

@Controller
public class ItemSeguroAutomovelController extends ItemController{
	
	@Autowired
	private ItemSeguroAutomovelService service;
	
	@RequestMapping(value = "/item/cadastro-seguroAutomovel")
	public ModelAndView cadastro(ItemSeguroAutomovel itemSeguroAutomovel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAutomovel");
		this.segurado = itemSeguroAutomovel.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroAutomovel")
	public ModelAndView gravar(ItemSeguroAutomovel itemSeguroCarro) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAutomovel");
		itemSeguroCarro.setSegurado(segurado);
		service.salvar(itemSeguroCarro);
		return view;
	}
	
	
	@RequestMapping(value="/item/automovel/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}
	
	
}
