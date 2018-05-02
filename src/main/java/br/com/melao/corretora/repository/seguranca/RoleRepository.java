package br.com.melao.corretora.repository.seguranca;

import br.com.melao.corretora.model.comum.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
