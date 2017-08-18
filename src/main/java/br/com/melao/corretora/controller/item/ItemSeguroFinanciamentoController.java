package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroFinanciamento;
import br.com.melao.corretora.service.item.ItemSeguroFinanciamentoService;

@Controller
@RequestMapping("/item")
public class ItemSeguroFinanciamentoController extends ItemController {

	@Autowired
	private ItemSeguroFinanciamentoService service;

	public ItemSeguroFinanciamentoController() {
	}

	@RequestMapping(value = "/cadastro-seguroFinanciamento")
	public ModelAndView cadastro(ItemSeguroFinanciamento itemSeguroFinanciamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroFinanciamento");
		this.segurado = itemSeguroFinanciamento.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroFinanciamento")
	public ModelAndView gravar(ItemSeguroFinanciamento itemSeguroFinanciamento, RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroFinanciamento");
		itemSeguroFinanciamento.setSegurado(segurado);
		service.salvar(itemSeguroFinanciamento);
		attributes.addFlashAttribute("mensagem" , "Seguro de Financiamento cadastrado com sucesso!" );
		return view;
	}
	
	@RequestMapping(value="/financiamento/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
