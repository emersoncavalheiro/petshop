package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRowMapper.ClienteRowMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteRepository {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public ClienteRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    @Transactional
    @Modifying
    public Cliente save(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    public List<Cliente> findAll() {

        return entityManager.createQuery("from Cliente").getResultList();
    }

    public Cliente findById(Long id){
        return(Cliente) entityManager.createQuery("from Cliente Where id = :id").setParameter("id" , id).getSingleResult();
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        entityManager.createQuery("delete from Cliente Where id = :id").setParameter("id", id).executeUpdate();

    }
}
