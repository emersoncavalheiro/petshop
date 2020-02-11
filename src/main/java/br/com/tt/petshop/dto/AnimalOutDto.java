package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class AnimalOutDto {

    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String clienteNome;

    public AnimalOutDto(Animal entidade){
        id = entidade.getId();
        nome = entidade.getNome();
        nascimento = entidade.getNascimento();
        clienteNome = entidade.getCliente().getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}
