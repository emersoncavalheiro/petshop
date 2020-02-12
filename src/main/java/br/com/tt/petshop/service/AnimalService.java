package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> findById(Long id){
        return animalRepository.findById(id);
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public void criar(Animal animal) {
        this.animalRepository.save(animal);
    }

    public Animal salvar(Animal animal) {
        return this.animalRepository.save(animal);
    }
}
