package br.com.melao.corretora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.ItemSeguroCarro;

@Repository
public interface ItemSeguro extends JpaRepository<ItemSeguroCarro, Long>{
	
}
