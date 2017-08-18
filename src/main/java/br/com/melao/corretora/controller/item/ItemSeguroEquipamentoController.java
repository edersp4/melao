package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroEquipamento;
import br.com.melao.corretora.service.item.ItemSeguroEquipamentoService;

@Controller
@RequestMapping("/item")
public class ItemSeguroEquipamentoController extends ItemController {

	@Autowired
	private ItemSeguroEquipamentoService service;

	public ItemSeguroEquipamentoController() {
	}

	@RequestMapping(value = "/cadastro-seguroEquipamento")
	public ModelAndView cadastro(ItemSeguroEquipamento itemSeguroEquipamento) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEquipamento");
		this.segurado = itemSeguroEquipamento.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroEquipamento")
	public ModelAndView gravar(ItemSeguroEquipamento itemSeguroEquipamento , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroEquipamento");
		itemSeguroEquipamento.setSegurado(segurado);
		service.salvar(itemSeguroEquipamento);
		attributes.addFlashAttribute("mensagem" , "Seguro de Equipamento cadastrado com sucesso!" );
		
		return view;
	}
	
	@RequestMapping(value="/equipamento/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
