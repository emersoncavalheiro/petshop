package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRowMapper.ClienteRowMapper;
import br.com.tt.petshop.repository.UnidadeRowMapper.UnidadeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente save(Cliente cliente){
        jdbcTemplate.update("insert into cliente (nome, cpf, datadenascimento) values (? , ?, ?)", cliente.getNome(), cliente.getCpf(), cliente.getNascimento());
        return cliente;
    }

    public List<Cliente> findAll(){

        return jdbcTemplate.query("select id , nome, cpf, datadenascimento from cliente" , new ClienteRowMapper());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from cliente where id= ?", id);
    }
}
