package br.com.melao.corretora.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.Usuario;
import br.com.melao.corretora.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioService() {
	}
	
	
	public boolean isLoginValido(Usuario usuario) {
		Usuario usuarioLogado = repository.findByLogin(usuario.getLogin());
		
		if(usuarioLogado != null) {
			if(usuarioLogado.getPassword().equals(usuario.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

}
