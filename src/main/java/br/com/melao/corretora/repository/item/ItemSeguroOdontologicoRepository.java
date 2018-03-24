package br.com.melao.corretora.repository.item;

import br.com.melao.corretora.repository.comum.ItemSeguroBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.melao.corretora.model.item.ItemSeguroOdontologico;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSeguroOdontologicoRepository extends ItemSeguroBaseRepository<ItemSeguroOdontologico> {

}
