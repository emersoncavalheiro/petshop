package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public void criar(Unidade unidade){
        this.unidadeRepository.save(unidade);

    }

    public List<Unidade> listar(){
        return this.unidadeRepository.findAll();
    }

    public void excluir(String nome){
        this.unidadeRepository.delete(nome);

    }

    public Unidade buscarPorID(Long id) {
        return this.unidadeRepository.findById(id);

    }

    public void deletarPorId(Long id){
        this.unidadeRepository.deleteById(id);
    }
}
