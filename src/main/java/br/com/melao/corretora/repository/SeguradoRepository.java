package br.com.melao.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.Segurado;

@Repository
public interface SeguradoRepository extends JpaRepository<Segurado, Long> ,QueryByExampleExecutor<Segurado> {
	
}
