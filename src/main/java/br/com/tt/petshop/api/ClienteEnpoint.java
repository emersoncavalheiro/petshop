package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteEnpoint {

    private final ClienteService clienteService;

    public ClienteEnpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> buscarTodos(){
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public Cliente buscaPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public void criar(@RequestBody Cliente cliente){
        clienteService.criar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletarPorId(id);
    }

}
