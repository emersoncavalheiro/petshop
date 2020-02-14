package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByValorGreaterThan(BigDecimal valorMaiorQue);

    List<Produto> findByDescricaoContaining(String descricao);

    List<Produto> findAllByValorGreaterThanAndDescricaoContaining(BigDecimal valorMaiorQue, String descricao);
}
