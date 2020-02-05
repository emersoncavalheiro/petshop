package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRowMapper.ClienteRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClienteRepository {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public ClienteRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public Cliente save(Cliente cliente){
        jdbcTemplate.update("insert into TB_CLIENTE (nome, cpf, datadenascimento) values (? , ?, ?)", cliente.getNome(), cliente.getCpf(), cliente.getNascimento());
        return cliente;
    }

    public List<Cliente> findAll(){

        return jdbcTemplate.query("select id , nome, cpf, datadenascimento from TB_CLIENTE" , new ClienteRowMapper());
    }

    public Cliente findById(Long id){
        return(Cliente) entityManager.createQuery("from Cliente Where id = :id").setParameter("id" , id).getSingleResult();
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from Cliente where id= ?", id);
    }
}
