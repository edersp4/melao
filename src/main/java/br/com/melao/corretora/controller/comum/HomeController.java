package br.com.melao.corretora.controller.comum;

import br.com.melao.corretora.model.comum.User;
import br.com.melao.corretora.service.comum.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private UserService service;

    HomeController controller;

   @Autowired
	public HomeController(UserService service) {
	      this.service = service;
   }

    @RequestMapping({"/" , ""})
    public String index(User usuario) {
        return "index";
    }
	

	@RequestMapping("login")
	public String loginForm() {
		return "login";
	}

    @RequestMapping("/access_denied")
    public String notAuth(){
        return "access_denied";
    }
	
}
