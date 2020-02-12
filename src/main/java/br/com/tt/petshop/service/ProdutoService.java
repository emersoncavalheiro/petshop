package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listar(BigDecimal valorMaiorQue, String descricao) {
        if(valorMaiorQue != null && descricao == null) {
            return produtoRepository.findAllByValorGreaterThan(valorMaiorQue);
        }
        else if(descricao != null && valorMaiorQue == null){
            return produtoRepository.findByDescricaoContaining(descricao);
        }
        else if(valorMaiorQue != null && descricao != null){
            return produtoRepository.findAllByValorGreaterThanAndDescricaoContaining(valorMaiorQue, descricao);
        }
        return produtoRepository.findAll();
    }
}
