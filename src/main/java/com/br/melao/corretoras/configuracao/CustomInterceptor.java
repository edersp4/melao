package com.br.melao.corretoras.configuracao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor{

	public CustomInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		String uri = request.getRequestURI();
		
		if(uri.equals("/") || uri.equals("/home") || uri.equals("/console")) {
			return true;
		}
		
		
		if(request.getSession().getAttribute("usuarioLogado") == null) {
			response.sendRedirect("/");
			return false;
		}else {
			return true;
		}
	}

}
