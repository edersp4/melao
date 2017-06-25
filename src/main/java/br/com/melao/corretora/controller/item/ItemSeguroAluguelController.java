package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroAluguel;
import br.com.melao.corretora.service.item.ItemSeguroAluguelService;

@Controller
public class ItemSeguroAluguelController extends ItemController {

	@Autowired
	private ItemSeguroAluguelService service;

	public ItemSeguroAluguelController() {
	}

	@RequestMapping(value = "/item/cadastro-seguroAluguel")
	public ModelAndView cadastro(ItemSeguroAluguel itemSeguroAluguel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAluguel");
		this.segurado = itemSeguroAluguel.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroAluguel")
	public ModelAndView gravar(ItemSeguroAluguel itemSeguroAluguel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAluguel");
		itemSeguroAluguel.setSegurado(segurado);
		service.salvar(itemSeguroAluguel);
		return view;
	}
	
	
	@RequestMapping(value="/item/aluguel/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}


}
