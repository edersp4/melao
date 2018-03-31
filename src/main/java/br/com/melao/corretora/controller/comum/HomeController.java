package br.com.melao.corretora.controller.comum;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.melao.corretora.model.comum.Usuario;
import br.com.melao.corretora.service.comum.UsuarioService;

@Controller
public class HomeController {

    private UsuarioService service;

    HomeController controller;

    @Autowired
    public HomeController(UsuarioService service) {
        this.service = service;
    }

    @RequestMapping("/")
	public ModelAndView index(Usuario usuario) {
        return new ModelAndView("/home/index");
	}
	
	@RequestMapping("/home/home")
	public ModelAndView home() {
        return new ModelAndView("/home/home");
	}
	
	@RequestMapping("/home")
	public ModelAndView login(Usuario usuario , HttpSession session) {
		ModelAndView view;
		if(service.isLoginValido(usuario)) {
			view = new ModelAndView("redirect:/home/home");
			session.setAttribute("usuarioLogado", usuario);
		}else {
			view = new ModelAndView("redirect:/");
		}
		
		return view;
	}
	
}
