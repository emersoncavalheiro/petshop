package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRowMapper.UnidadeRowMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public UnidadeRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public Unidade update(Unidade unidade){
        Unidade unidadeSalva = entityManager.merge(unidade);
        return unidadeSalva;
    }

    public Unidade save(Unidade unidade){

        jdbcTemplate.update("insert into TB_UNIDADE (nome, endereco) values (? , ?)", unidade.getNome(), unidade.getEndereco());

        return unidade;
    }

    public List<Unidade> findAll(){

        return jdbcTemplate.query("select id, nome, endereco from TB_UNIDADE" , new Object[] {}, new UnidadeRowMapper());

    }

    public void delete(String nome) {
//
        jdbcTemplate.update("delete from TB_UNIDADE Where nome = ?" , nome);

    }

    public Unidade findById(Long id) {
        return (Unidade) entityManager.createQuery("from Unidade Where id = :id").setParameter("id", id).getSingleResult();
    }

    @Modifying
    @Transactional
    public void deleteById(Long id){
        entityManager.createQuery("delete from Unidade Where id = :id").setParameter("id", id).executeUpdate();

    }


}
