package br.com.melao.corretora.repository.comum;

import br.com.melao.corretora.model.comum.User;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UsuarioRepositoryTest {
//
//    @Autowired
//    UserRepository usuarioRepository;
//
//
//
//    @Test
//    public void findByLogin() {
//
//    }
//}