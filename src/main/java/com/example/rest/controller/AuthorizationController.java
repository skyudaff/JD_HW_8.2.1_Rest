package com.example.rest.controller;

import com.example.rest.exception.InvalidCredentials;
import com.example.rest.exception.UnauthorizedUser;
import com.example.rest.model.Authorities;
import com.example.rest.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> incHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unaHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(401));
    }
}