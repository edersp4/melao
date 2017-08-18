package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroVida;
import br.com.melao.corretora.service.item.ItemSeguroVidaService;

@Controller
@RequestMapping("/item")
public class ItemSeguroVidaController extends ItemController {

	@Autowired
	private ItemSeguroVidaService service;

	public ItemSeguroVidaController() {
	}

	@RequestMapping(value = "/cadastro-seguroVida")
	public ModelAndView cadastro(ItemSeguroVida itemSeguroVida) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroVida");
		this.segurado = itemSeguroVida.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroVida")
	public ModelAndView gravar(ItemSeguroVida itemSeguroVida, RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroVida");
		itemSeguroVida.setSegurado(segurado);
		service.salvar(itemSeguroVida);
		attributes.addFlashAttribute("mensagem" , "Seguro de Vida cadastrado com sucesso!" );
		return view;
	}
	
	@RequestMapping(value="/vida/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
