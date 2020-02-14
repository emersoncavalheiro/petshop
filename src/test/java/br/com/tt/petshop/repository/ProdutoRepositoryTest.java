package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@Sql(value = "classpath:/popula_produtos.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:/limpa_produtos.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    public void deveriaRetornarValorMaiorQue50(){
        //Preparacao

        //acao
        BigDecimal vl = BigDecimal.valueOf(50);
        List<Produto> resultado = produtoRepository.findAllByValorGreaterThan(vl);

        //verificacao
        Assertions.assertEquals(1, resultado.size());
        Produto banhoETosa = resultado.get(0);
        Assertions.assertEquals("Banho e Tosa", banhoETosa.getDescricao());
        Assertions.assertEquals(3, banhoETosa.getId());
        Assertions.assertEquals(BigDecimal.valueOf(75).setScale(2), banhoETosa.getValor());

    }
}