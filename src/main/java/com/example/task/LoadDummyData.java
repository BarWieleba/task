package com.example.task;

import com.example.task.Entities.AnimalEntity;
import com.example.task.Entities.DetailedInfoEntity;
import com.example.task.Repositories.AnimalRepository;
import com.example.task.Repositories.DetailedInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDummyData {
    private static final Logger log = LoggerFactory.getLogger(LoadDummyData.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository animalRepository, DetailedInfoRepository infoRepository){

        AnimalEntity animal1 = new AnimalEntity("Alex", "Alabai", "Dog", 3);
        AnimalEntity animal2 = new AnimalEntity("Sara", "Domestic short-haired", "Cat", 4);

        return args -> {
            log.info("Preloading "+animalRepository.save(animal1));
            log.info("Preloading "+animalRepository.save(animal2));
            log.info("Preloading "+infoRepository.save(new DetailedInfoEntity("John", "Smith", "New York", "Wall Street", 5, animal1)));
            log.info("Preloading "+infoRepository.save(new DetailedInfoEntity("Dominic", "Miller", "Topeka", "SE Adams St", 21, animal2)));
        };
    }
}
