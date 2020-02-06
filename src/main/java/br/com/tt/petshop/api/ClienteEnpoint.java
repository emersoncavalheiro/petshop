package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteEnpoint {

    private final ClienteService clienteService;

    public ClienteEnpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).header("X-SITUACAO", "Ativos").body(clienteService.listar());
    }

    @GetMapping("/{id}")
    public Cliente buscaPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Cliente cliente){
        Cliente clienteSalvo = clienteService.criar(cliente);
        URI uri = URI.create("/clientes/"+clienteSalvo.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        clienteService.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

}
