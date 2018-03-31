package br.com.melao.corretora;

import br.com.melao.corretora.model.comum.Usuario;
import br.com.melao.corretora.service.comum.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MelaoCorretorasApplicationTests {

	@Autowired
    UsuarioService service;


	@Test
	public void contextLoads() {



	}

}
