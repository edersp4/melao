package br.com.melao.corretora.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.item.ItemSeguroEmpresarial;

@Repository
public interface ItemSeguroEmpresarialRepository extends JpaRepository<ItemSeguroEmpresarial, Long>{
	
}
