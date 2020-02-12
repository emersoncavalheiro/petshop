package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Produto;

import java.math.BigDecimal;

public class ProdutoOutDto {
    private Long id;
    private BigDecimal valor;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
