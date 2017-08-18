package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguroEmpresarial;
import br.com.melao.corretora.service.item.ItemSeguroEmpresarialService;

@Controller
@RequestMapping("/item")
public class ItemSeguroEmpresarialController extends ItemController {

	@Autowired
	private ItemSeguroEmpresarialService service;

	public ItemSeguroEmpresarialController() {
	}

	@RequestMapping(value = "/cadastro-seguroEmpresarial")
	public ModelAndView cadastro(ItemSeguroEmpresarial itemSeguroEmpresarial) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroEmpresarial");
		this.segurado = itemSeguroEmpresarial.getSegurado();
		return view;
	}

	@RequestMapping(value = "/gravar-seguroEmpresarial")
	public ModelAndView gravar(ItemSeguroEmpresarial itemSeguroEmpresarial , RedirectAttributes attributes) {
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroEmpresarial");
		itemSeguroEmpresarial.setSegurado(segurado);
		service.salvar(itemSeguroEmpresarial);
		
		attributes.addFlashAttribute("mensagem" , "Seguro Empresarial cadastrado com sucesso!" );
		
		return view;
	}
	
	@RequestMapping(value="/empresarial/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
