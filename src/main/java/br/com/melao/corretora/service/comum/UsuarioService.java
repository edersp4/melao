package br.com.melao.corretora.service.comum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.melao.corretora.model.comum.Usuario;
import br.com.melao.corretora.repository.comum.UsuarioRepository;

@Service
public class UsuarioService {


	private UsuarioRepository repository;

	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public boolean isLoginValido(Usuario usuario) {
        Usuario usuarioLogado = repository.findByLogin(usuario.getLogin());

        return usuarioLogado != null && usuarioLogado.getPassword().equals(usuario.getPassword());

    }

	public Usuario save(Usuario s) {
		return repository.save(s);
	}



}
