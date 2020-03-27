package com.example.demo.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// this exception is associated with 404 error
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundError extends RuntimeException{
    public CustomerNotFoundError (String message) {
        super(message);
    }
}
