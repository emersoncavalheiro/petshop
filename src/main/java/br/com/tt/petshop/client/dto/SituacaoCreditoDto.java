package br.com.tt.petshop.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SituacaoCreditoDto {
    public boolean isNegativado;
    private String situacao;

    @JsonProperty("pontos")
    private int pontuacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isNegativado(){
        return "NEGATIVADO".equalsIgnoreCase(situacao);
    }
}
