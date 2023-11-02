package com.example.rest.controller;

import com.example.rest.model.Authorities;
import com.example.rest.model.User;
import com.example.rest.service.AuthorizationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}