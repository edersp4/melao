package br.com.melao.corretora.controller.item;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.item.ItemSeguroPrevidencia;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroPrevidenciaVidaService;

@Controller
public class ItemSeguroPrevidenciaController extends ItemController {

	private Segurado segurado;

	@Autowired
	private ItemSeguroPrevidenciaVidaService service;

	public ItemSeguroPrevidenciaController() {
	}

	@RequestMapping(value = "/item/cadastro-seguroPrevidencia")
	public ModelAndView cadastro(ItemSeguroPrevidencia itemSeguroPrevidencia) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroPrevidencia");
		this.segurado = itemSeguroPrevidencia.getSegurado();
		return view;
	}

	@RequestMapping(value = "/item/gravar-seguroPrevidencia")
	public ModelAndView gravar(ItemSeguroPrevidencia itemSeguroPrevidencia) {
		ModelAndView view = new ModelAndView("item/cadastro-seguroPrevidencia");
		itemSeguroPrevidencia.setSegurado(segurado);
		service.salvar(itemSeguroPrevidencia);
		return view;
	}
	
	@RequestMapping(value="/item/previdencia/{seg:.+}" , method=RequestMethod.GET)
	public void selecionarSegurado(@PathVariable(name="seg") String seguradoNomeCPF, HttpServletResponse response) {
		selecionarSegurado(seguradoNomeCPF);
		response.setStatus(200);
	}

}
