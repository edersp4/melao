package br.com.melao.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.ItemSeguroAutomovel;

@Repository
public interface ItemSeguroRepository extends JpaRepository<ItemSeguroAutomovel, Long>{
	
}
