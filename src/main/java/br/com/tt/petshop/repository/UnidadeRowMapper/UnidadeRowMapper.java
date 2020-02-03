package br.com.tt.petshop.repository.UnidadeRowMapper;

import br.com.tt.petshop.model.Unidade;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnidadeRowMapper implements RowMapper<Unidade> {

    @Override
    public Unidade mapRow(ResultSet rs, int rowNum) throws SQLException {
        Unidade unidade = new Unidade();
        unidade.setNome(rs.getString("nome"));
        unidade.setEndereco(rs.getString("endereco"));
        return unidade;
    }
}
