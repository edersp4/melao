package br.com.melao.corretora.repository.segurado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.segurado.Segurado;

@Repository
public interface SeguradoRepository extends JpaRepository<Segurado, Long> ,QueryByExampleExecutor<Segurado> {
	public List<Segurado> findAllByOrderByNomeAsc();
}
