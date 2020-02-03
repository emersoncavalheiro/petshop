package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRowMapper.UnidadeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<Unidade> db = new ArrayList<>();

    public Unidade save(Unidade unidade){

        jdbcTemplate.update("insert into unidade (nome, endereco) values (? , ?)", unidade.getNome(), unidade.getEndereco());

        return unidade;
    }

    public List<Unidade> findAll(){

        return jdbcTemplate.query("select nome, endereco from unidade" , new Object[] {}, new UnidadeRowMapper());

    }

    public void delete(String nome) {
//
        jdbcTemplate.update("delete from unidade Where nome = ?" , nome);

    }
}
