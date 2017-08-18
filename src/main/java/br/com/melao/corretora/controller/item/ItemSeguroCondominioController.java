package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroCondominio;
import br.com.melao.corretora.service.item.ItemSeguroCondominioService;

@Controller
@RequestMapping("/item")
public class ItemSeguroCondominioController extends ItemController {

	@Autowired
	private ItemSeguroCondominioService service;

	public ItemSeguroCondominioController() {
	}

	@RequestMapping(value = "/cadastro-seguroCondominio")
	public ModelAndView cadastro(ItemSeguroCondominio itemSeguroCondominio) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroCondominio");
		this.segurado = itemSeguroCondominio.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroCondominio")
	public ModelAndView gravar(ItemSeguroCondominio itemSeguroCondominio , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroCondominio");
		itemSeguroCondominio.setSegurado(segurado);
		service.salvar(itemSeguroCondominio);
		attributes.addFlashAttribute("mensagem" , "Seguro de Condomínio cadastrado com sucesso!" );
		return view;
	}
	
	@RequestMapping(value="/condominio/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
