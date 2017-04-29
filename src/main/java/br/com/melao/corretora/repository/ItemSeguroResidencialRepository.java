package br.com.melao.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.ItemSeguroResidencial;

@Repository
public interface ItemSeguroResidencialRepository extends JpaRepository<ItemSeguroResidencial, Long>{
	
}
