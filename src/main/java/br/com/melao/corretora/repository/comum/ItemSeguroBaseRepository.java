package br.com.melao.corretora.repository.comum;

import br.com.melao.corretora.model.item.ItemSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ItemSeguroBaseRepository<T extends ItemSeguro> extends JpaRepository<ItemSeguro, Long> {
}
