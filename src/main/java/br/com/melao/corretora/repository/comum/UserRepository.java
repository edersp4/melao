package br.com.melao.corretora.repository.comum;

import br.com.melao.corretora.model.comum.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String name);
}
