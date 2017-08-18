package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroRastreador;
import br.com.melao.corretora.service.item.ItemSeguroRastreadorService;

@Controller
@RequestMapping("/item")
public class ItemSeguroRastreadorController extends ItemController {

	@Autowired
	private ItemSeguroRastreadorService service;

	@RequestMapping(value = "/cadastro-seguroRastreador")
	public ModelAndView cadastro(ItemSeguroRastreador itemSeguroRastreador) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroRastreador");
		this.segurado = itemSeguroRastreador.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroRastreador")
	public ModelAndView gravar(ItemSeguroRastreador itemSeguroRastreador , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroRastreador");
		itemSeguroRastreador.setSegurado(segurado);
		service.salvar(itemSeguroRastreador);
		attributes.addFlashAttribute("mensagem" , "Seguro de Rastreador cadastrado com sucesso!" );
		return view;
	}

	
	@RequestMapping(value="/rastreador/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}
}
