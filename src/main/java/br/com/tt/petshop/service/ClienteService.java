package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void criar(Cliente cliente){
        this.clienteRepository.save(cliente);

    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public void excluir(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
