package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private AnimalService animalService;

    public AnimalEndpoint(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalOutDto> findById(@PathVariable Long id){

        Optional<Animal> animalOpt = animalService.findById(id);
        AnimalOutDto dto = animalOpt.map(a -> new AnimalOutDto(a)).orElseThrow(() -> new IllegalArgumentException("Animal não existe"));

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalOutDto>> findAll(){
        List<Animal> listaAnimais = animalService.findAll();
        List<AnimalOutDto> listaAuxiliar = new ArrayList<>();

        for (Animal animal: listaAnimais) {
            listaAuxiliar.add(new AnimalOutDto(animal));
        }
        return ResponseEntity.ok(listaAuxiliar);
    }

}
