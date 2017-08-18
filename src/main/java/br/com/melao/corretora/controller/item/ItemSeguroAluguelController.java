package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroAluguel;
import br.com.melao.corretora.service.item.ItemSeguroAluguelService;

@Controller
@RequestMapping("/item")
public class ItemSeguroAluguelController extends ItemController {

	@Autowired
	private ItemSeguroAluguelService service;

	public ItemSeguroAluguelController() {
	}

	@RequestMapping(value = "/cadastro-seguroAluguel")
	public ModelAndView cadastro(ItemSeguroAluguel itemSeguroAluguel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAluguel");
		this.segurado = itemSeguroAluguel.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroAluguel")
	public ModelAndView gravar(ItemSeguroAluguel itemSeguroAluguel , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroAluguel");
		itemSeguroAluguel.setSegurado(segurado);
		service.salvar(itemSeguroAluguel);
		attributes.addFlashAttribute("mensagem" , "Seguro de Aluguel cadastrado com sucesso!" );
		return view;
	}
	
	
	@RequestMapping(value="/aluguel/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}


}
