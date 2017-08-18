package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroResidencial;
import br.com.melao.corretora.service.item.ItemSeguroResidencialService;

@Controller
@RequestMapping("/item")
public class ItemSeguroResidencialController extends ItemController {

	@Autowired
	private ItemSeguroResidencialService service;

	public ItemSeguroResidencialController() {
	}

	@RequestMapping(value = "/cadastro-seguroResidencial")
	public ModelAndView cadastro(ItemSeguroResidencial itemSeguroResidencial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroResidencial");
		this.segurado = itemSeguroResidencial.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroResidencial")
	public ModelAndView gravar(ItemSeguroResidencial itemSeguroResidencial , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroResidencial");
		itemSeguroResidencial.setSegurado(segurado);
		service.salvar(itemSeguroResidencial);
		attributes.addFlashAttribute("mensagem" , "Seguro Residencial cadastrado com sucesso!" );
		return view;
	}
	
	
	@RequestMapping(value="/residencial/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
