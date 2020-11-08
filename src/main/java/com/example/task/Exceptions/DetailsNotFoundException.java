package com.example.task.Exceptions;

public class DetailsNotFoundException extends RuntimeException{
    public DetailsNotFoundException(Long id){
        super("Could not find details "+id);
    }
}
