package com.example.task.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class AnimalEntity {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String breed;
    private String specie;
    private int age;

    public AnimalEntity() {}

    public AnimalEntity(String name, String breed, String specie, int age){
        this.name = name;
        this.breed = breed;
        this.specie = specie;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getSpecie() {
        return specie;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof AnimalEntity)){
            return false;
        }
        AnimalEntity animalEntity = (AnimalEntity) obj;
        return Objects.equals(this.id, animalEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.breed, this.age);
    }

    @Override
    public String toString() {
        return "Animal{"+"id="+this.id+", name='" + this.name +'\'' + ", breed='"+this.breed + '\'' + ", age='"+ this.age +'\''+'}';
    }
}
