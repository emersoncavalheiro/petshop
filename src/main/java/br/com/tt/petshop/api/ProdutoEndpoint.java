package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoEndpoint {

    private ProdutoService produtoService;

    public ProdutoEndpoint(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Produto produto){
        Produto produtoSalvo = produtoService.salvar(produto);

        return ResponseEntity.created(URI.create("/produtos/"+produtoSalvo.getId())).build();

    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(@RequestParam(required = false) BigDecimal valorMaiorQue, String descricao){
        return ResponseEntity.ok(produtoService.listar(valorMaiorQue, descricao));
    }

}
