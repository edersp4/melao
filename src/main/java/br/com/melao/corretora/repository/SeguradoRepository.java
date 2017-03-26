package br.com.melao.corretora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import br.com.melao.corretora.model.Segurado;


public interface SeguradoRepository extends JpaRepository<Segurado, Long> ,QueryByExampleExecutor<Segurado> {
	List<Segurado> findByNomeContaining(String nome);
	List<Segurado> findByCpfContaining(String cpf);
	List<Segurado> findByTelefoneContaining(String telefone);
	List<Segurado> findByCepContaining(String cep);
	
}
