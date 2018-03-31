package br.com.melao.corretora.repository.comum;

import br.com.melao.corretora.model.comum.Usuario;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;



    @Test
    public void findByLogin() {
        Usuario login = usuarioRepository.findByLogin("ed");
        assertThat(login, CoreMatchers.notNullValue());
        assertThat(login.getLogin(), is("ed"));
    }
}