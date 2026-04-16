package com.liimadev.sanguesolidario.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class MainController {

    @GetMapping
    public String hello() {
        return "Olá, mundo. Isso é uma aplicação Spring Boot! :>";
    }
}
