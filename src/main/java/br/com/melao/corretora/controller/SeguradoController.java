package br.com.melao.corretora.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.Segurado;
import br.com.melao.corretora.service.cadastro.SeguradoService;

@Controller
public class SeguradoController {
	
	@Autowired
	private SeguradoService seguradoService;
	
	@RequestMapping("/sucesso")
	public String sucesso() {
		return "sucesso";
	}
	
	@RequestMapping(value="/segurado/cadastro-segurado" , method=RequestMethod.GET)
	public ModelAndView cadastroSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/cadastro-segurado");
		return view;
	}
	
	@RequestMapping(value="/segurado/gravar" , method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Segurado segurado , BindingResult result) {
		if(result.hasErrors()) {
			return cadastroSegurado(segurado);
		}
		ModelAndView view = new ModelAndView("sucesso");
		
		seguradoService.gravarUsuarioOuAtualizar(segurado);
		return view;
	}
	
	@RequestMapping(value="/segurado/consulta-segurado" , method=RequestMethod.GET)
	public ModelAndView consultaSegurado(Segurado segurado) {
		ModelAndView  view= new ModelAndView("segurado/consulta-segurado");
		return view;
	}
	
	@RequestMapping(value="/segurado/buscar" , method=RequestMethod.GET)
	public ModelAndView buscar(Segurado segurado) {
		ModelAndView seguradosView = new ModelAndView("segurado/consulta-segurado");
		seguradosView.addObject("listaSegurados",seguradoService.buscarPorNome(segurado));
		segurado = new Segurado();
		return seguradosView;
	}
	
	@RequestMapping(value="/segurado/alterarSegurado" , method=RequestMethod.GET)
	public ModelAndView alterarSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/cadastro-segurado");
		segurado = seguradoService.detalheSegurado(segurado.getId());
		view.addObject(segurado);
		return view;
	}
	
	@RequestMapping(value="/segurado/detalhe-segurado" , method=RequestMethod.GET)
	public ModelAndView detalheSegurado(Segurado segurado) {
		ModelAndView view = new ModelAndView("segurado/consulta-segurado");
		segurado = seguradoService.detalheSegurado(segurado.getId());
		view.addObject("detalhe",segurado);
		return view;
	}
	
	
	
	
}
