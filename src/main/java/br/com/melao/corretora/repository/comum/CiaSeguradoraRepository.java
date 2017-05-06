package br.com.melao.corretora.repository.comum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.comum.CiaSeguro;

@Repository
public interface CiaSeguradoraRepository extends JpaRepository<CiaSeguro, Long>{
	public List<CiaSeguro> findAllByOrderByNomeAsc();
}
