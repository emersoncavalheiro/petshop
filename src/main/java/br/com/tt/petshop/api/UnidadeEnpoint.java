package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeEnpoint {

    private final UnidadeService unidadeService;

    public UnidadeEnpoint(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    //  @RequestMapping(value = "/unidades", method = RequestMethod.GET)
    @GetMapping
    public List<Unidade> buscarTodos(){
        return unidadeService.listar();
    }

    @GetMapping("/{id}")
    public Unidade buscaPorId(@PathVariable Long id){
        return unidadeService.buscarPorID(id);
    }

    @PostMapping
    public void criar(@RequestBody Unidade unidade){
        unidadeService.criar(unidade);

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        unidadeService.deletarPorId(id);

    }

}
