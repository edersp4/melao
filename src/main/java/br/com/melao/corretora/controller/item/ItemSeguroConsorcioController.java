package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroConsorcio;
import br.com.melao.corretora.service.item.ItemSeguroConsorcioService;

@Controller
@RequestMapping("/item")
public class ItemSeguroConsorcioController extends ItemController {

	@Autowired
	private ItemSeguroConsorcioService service;

	public ItemSeguroConsorcioController() {
	}

	@RequestMapping(value = "/cadastro-seguroConsorcio")
	public ModelAndView cadastro(ItemSeguroConsorcio itemSeguroConsorcio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroConsorcio");
		this.segurado = itemSeguroConsorcio.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroConsorcio")
	public ModelAndView gravar(ItemSeguroConsorcio itemSeguroConsorcio, RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroConsorcio");
		itemSeguroConsorcio.setSegurado(segurado);
		service.salvar(itemSeguroConsorcio);
		attributes.addFlashAttribute("mensagem" , "Seguro de Consórcio cadastrado com sucesso!" );
		return view;
	}
	
	
	@RequestMapping(value="/consorcio/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
