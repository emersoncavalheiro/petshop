package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalInDto;
import br.com.tt.petshop.dto.AnimalOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private AnimalService animalService;
    private ModelMapper modelMapper;

    public AnimalEndpoint(AnimalService animalService, ModelMapper modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalOutDto> findById(@PathVariable Long id){

        Optional<Animal> animalOpt = animalService.findById(id);
        AnimalOutDto dto = animalOpt.map(a -> new AnimalOutDto(a)).orElseThrow(() -> new IllegalArgumentException("Animal não existe"));

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalOutDto>> findAll(){
        return ResponseEntity.ok(animalService
                .findAll().stream()
                .map(AnimalOutDto::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid AnimalInDto animalDto){

        Animal animal = modelMapper.map(animalDto, Animal.class);

        Animal animalSalvo = this.animalService.salvar(animal);

        return ResponseEntity.created(URI.create("/animais/" + animalSalvo.getId())).build();

    }

}
