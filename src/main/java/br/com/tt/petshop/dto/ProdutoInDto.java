package br.com.tt.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutoInDto {

    @NotNull(message = "O valor deve ser preenchido!")
    @Positive(message = "Digite um valor maior que zero!")
    private BigDecimal valor;

    @NotBlank(message = "Preencha a descricao do produto!")
    private String descricao;

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
