package com.spm.eventmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

}

//Notes

/*
The @ResponseStatus annotation is used in Spring MVC to declare the HTTP status code to be returned by a controller method or an exception handler method. It allows you to customize the HTTP response status based on the outcome of the method execution or the encountered exception.
* */
