package br.com.tt.petshop.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    //TODO converter para localdate
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
