package br.com.melao.corretora.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.CiaSeguro;
import br.com.melao.corretora.model.item.ItemSeguroPrevidencia;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.item.ItemSeguroPrevidenciaVidaService;

@Controller
public class ItemSeguroPrevidenciaController {

	
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
	
	
	@ModelAttribute("listaCiaSeguro")
	public List<CiaSeguro> popularCiaSeguradora(){
		return service.carregarSeguradora();
	}


}
