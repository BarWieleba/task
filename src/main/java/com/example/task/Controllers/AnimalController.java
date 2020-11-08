package com.example.task.Controllers;


import com.example.task.Entities.AnimalEntity;
import com.example.task.Exceptions.AnimalNotFoundException;
import com.example.task.Repositories.AnimalRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    private final AnimalRepository repository;
    AnimalController(AnimalRepository repository){
        this.repository = repository;
    }

    @GetMapping("/animals")
    //@RequestMapping(value = "/animals", method = RequestMethod.GET)
    List<AnimalEntity> all(){
        return repository.findAll();
    }

    //@PostMapping("/newAnimal")
    @PostMapping(path = "/animals", consumes = "application/json", produces = "application/json")
    AnimalEntity newAnimal (@RequestBody AnimalEntity newAnimal){
        return repository.save(newAnimal);
    }

    @GetMapping("/animals/{id}")
    AnimalEntity one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new AnimalNotFoundException(id));
    }

    @PutMapping("/animals/{id}")
    AnimalEntity replaceAnimal(@RequestBody AnimalEntity newAnimal, @PathVariable Long id){
        return repository.findById(id)
                .map(animalEntity -> {
                    animalEntity.setName(newAnimal.getName());
                    animalEntity.setSpecie(newAnimal.getSpecie());
                    animalEntity.setBreed(newAnimal.getBreed());
                    animalEntity.setAge(newAnimal.getAge());
                    return repository.save(animalEntity);
                })
                .orElseGet(()->{
                    newAnimal.setId(id);
                    return repository.save(newAnimal);
                });
    }

    @DeleteMapping("/animals/{id}")
    void deleteAnimal(@PathVariable Long id){
        repository.deleteById(id);
    }

}
