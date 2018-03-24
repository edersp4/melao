package br.com.melao.corretora.repository.item;

import br.com.melao.corretora.repository.comum.ItemSeguroBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.melao.corretora.model.item.ItemSeguroVida;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSeguroVidaRepository extends ItemSeguroBaseRepository<ItemSeguroVida> {

}
