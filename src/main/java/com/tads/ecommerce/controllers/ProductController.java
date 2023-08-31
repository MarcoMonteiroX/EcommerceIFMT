package com.tads.ecommerce.controllers;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @GetMapping(value = "/teste")
    public String teste(@RequestParam(value = "texto", defaultValue = "Mundo") String texto) {
        return "Olá " + texto;
    }


    @GetMapping
    public String teste() {
        return "primeira rota.";
    }

}
