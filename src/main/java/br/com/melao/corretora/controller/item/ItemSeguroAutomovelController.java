package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroAutomovel;
import br.com.melao.corretora.service.item.ItemSeguroAutomovelService; 

@Controller
@RequestMapping("/item")
public class ItemSeguroAutomovelController extends ItemController{
	
	@Autowired
	private ItemSeguroAutomovelService service;
	
	@RequestMapping(value = "/cadastro-seguroAutomovel")
	public ModelAndView cadastro(ItemSeguroAutomovel itemSeguroAutomovel) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroAutomovel");
		this.segurado = itemSeguroAutomovel.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroAutomovel")
	public ModelAndView gravar(ItemSeguroAutomovel itemSeguroCarro , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroAutomovel");
		itemSeguroCarro.setSegurado(segurado);
		service.salvar(itemSeguroCarro);
		attributes.addFlashAttribute("mensagem" , "Seguro de Automóvel cadastrado com sucesso!" );
		return view;
	}
	
	
	@RequestMapping(value="/automovel/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}
	
	
}
