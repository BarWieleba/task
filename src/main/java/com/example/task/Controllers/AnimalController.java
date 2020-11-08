package com.example.task.Controllers;


import com.example.task.Entities.AnimalEntity;
import com.example.task.Exceptions.AnimalNotFoundException;
import com.example.task.Repositories.AnimalRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    private final AnimalRepository repository;
    AnimalController(AnimalRepository repository){
        this.repository = repository;
    }

    @GetMapping("/animals")
    List<AnimalEntity> all(){
        return repository.findAll();
    }

    @PostMapping(value = "/animals", consumes = "application/json")
    AnimalEntity newAnimal (@RequestBody List<AnimalEntity> list){
        return repository.save(list.get(0));
    }

    @GetMapping("/animals/{id}")
    AnimalEntity one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new AnimalNotFoundException(id));
    }

    @PutMapping("/animals/{id}")
    AnimalEntity replaceAnimal(@RequestBody List<AnimalEntity> list, @PathVariable Long id){
        return repository.findById(id)
                .map(animalEntity -> {
                    animalEntity.setName(list.get(0).getName());
                    animalEntity.setSpecie(list.get(0).getSpecie());
                    animalEntity.setBreed(list.get(0).getBreed());
                    animalEntity.setAge(list.get(0).getAge());
                    return repository.save(animalEntity);
                })
                .orElseGet(()->{
                    list.get(0).setId(id);
                    return repository.save(list.get(0));
                });
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimal(@PathVariable Long id){
        repository.deleteById(id);
    }

}
