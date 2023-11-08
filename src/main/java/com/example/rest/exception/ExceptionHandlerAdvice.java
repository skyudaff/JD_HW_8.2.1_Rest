package com.example.rest.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> incHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unaHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> anvHandler(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(404));
    }
}
