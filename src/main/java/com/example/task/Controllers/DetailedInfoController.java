package com.example.task.Controllers;

import com.example.task.Entities.DetailedInfoEntity;
import com.example.task.Exceptions.DetailsNotFoundException;
import com.example.task.Repositories.DetailedInfoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailedInfoController {
    private final DetailedInfoRepository repository;
    DetailedInfoController(DetailedInfoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/details")
    List<DetailedInfoEntity> all(){
        return repository.findAll();
    }

    @PostMapping("/details")
    DetailedInfoEntity newDetail(@RequestBody List<DetailedInfoEntity> list){
        return repository.save(list.get(0));
    }

    @GetMapping("/details/{id}")
    DetailedInfoEntity one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()->new DetailsNotFoundException(id));
    }

    @PutMapping("/details/{id}")
    DetailedInfoEntity replaceDetail(@RequestBody DetailedInfoEntity newDetail, @PathVariable Long id){
        return repository.findById(id)
                .map(detailedInfoEntity -> {
                    detailedInfoEntity.setOwnerName(newDetail.getOwnerName());
                    detailedInfoEntity.setOwnerSurname(newDetail.getOwnerSurname());
                    detailedInfoEntity.setCityAddress(newDetail.getCityAddress());
                    detailedInfoEntity.setStreetAddress(newDetail.getStreetAddress());
                    detailedInfoEntity.setBuildingNumberAddress(newDetail.getBuildingNumberAddress());
                    detailedInfoEntity.setAnimalEntity(newDetail.getAnimalEntity());
                    return repository.save(detailedInfoEntity);
                })
                .orElseGet(()->{
                    newDetail.setId(id);
                    return repository.save(newDetail);
                });
    }
}
