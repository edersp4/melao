package br.com.melao.corretora.repository;

import br.com.melao.corretora.model.seguranca.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users , Long>{

}
