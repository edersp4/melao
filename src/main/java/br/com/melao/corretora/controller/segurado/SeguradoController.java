package br.com.melao.corretora.controller.segurado;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melao.corretora.model.item.ItemSeguro;
import br.com.melao.corretora.model.item.ItemSeguroAutomovel;
import br.com.melao.corretora.model.segurado.Segurado;
import br.com.melao.corretora.service.segurado.SeguradoService;

@Controller
@RequestMapping("/segurado")
public class SeguradoController {
	
	@Autowired
	private SeguradoService seguradoService;
	
	
	
	@RequestMapping(value="/cadastro-segurado" , method=RequestMethod.GET)
	public ModelAndView cadastroSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/cadastro-segurado");
		return view;
	}
	
	@RequestMapping(value="/gravar" , method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Segurado segurado , BindingResult result , RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return cadastroSegurado(segurado);
		}
		seguradoService.gravarUsuarioOuAtualizar(segurado);
		ModelAndView view = new ModelAndView("redirect:/segurado/cadastro-segurado");
		attributes.addFlashAttribute("mensagem" , "Segurado Cadastrado com sucesso!" );
		
		return view;
	}
	
	@RequestMapping(value="/consulta-segurado" , method=RequestMethod.GET)
	public ModelAndView consultaSegurado(Segurado segurado) {
		ModelAndView  view= new ModelAndView("segurado/consulta-segurado");
		return view;
	}
	
	@RequestMapping(value="/buscar" , method=RequestMethod.GET)
	public ModelAndView buscar(Segurado segurado) {
		ModelAndView seguradosView = new ModelAndView("segurado/consulta-segurado");
		seguradosView.addObject("listaSegurados",seguradoService.buscarPorExemplo(segurado));
		segurado = new Segurado();
		return seguradosView;
	}
	
	@RequestMapping(value="/alterarSegurado" , method=RequestMethod.GET)
	public ModelAndView alterarSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/cadastro-segurado");
		segurado = seguradoService.detalheSegurado(segurado.getId());
		view.addObject(segurado);
		return view;
	}
	
	@RequestMapping(value="/visualizar" , method=RequestMethod.GET)
	public ModelAndView detalheSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/detalhe-segurado");
		segurado = seguradoService.detalheSegurado(segurado.getId());
		List<ItemSeguro> listaItemSeguro = segurado.getSeguro();
		view.addObject("listaItemSeguro", listaItemSeguro);
		view.addObject(segurado);
		return view;
	}
	
	
	@RequestMapping(value="/cadastrar-item")
	public ModelAndView cadastrarItem(Segurado segurado, final RedirectAttributes redirectAttributes ){
		ItemSeguroAutomovel item = new ItemSeguroAutomovel();
		segurado = seguradoService.detalheSegurado(segurado.getId());
		item.setSegurado(segurado);
		ModelAndView view = new ModelAndView("redirect:/item/cadastro-seguroAutomovel");
		redirectAttributes.addFlashAttribute(item);
		redirectAttributes.addFlashAttribute("listaItemSeguro" , segurado.getSeguro());
		return view;
	}
		
}
