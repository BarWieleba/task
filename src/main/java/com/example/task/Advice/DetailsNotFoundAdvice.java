package com.example.task.Advice;

import com.example.task.Exceptions.DetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DetailsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String detailNotFoundHandler(DetailsNotFoundException e){
        return e.getMessage();
    }
}
