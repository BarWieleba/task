package com.example.task.Exceptions;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(Long id){
        super("Could not find animal "+id);
    }
}
