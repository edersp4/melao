package br.com.melao.corretora.repository.item;

import br.com.melao.corretora.repository.comum.ItemSeguroBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.melao.corretora.model.item.ItemSeguroEquipamento;

@Repository
public interface ItemSeguroEquipamentoRepository extends ItemSeguroBaseRepository<ItemSeguroEquipamento> {
	
}
