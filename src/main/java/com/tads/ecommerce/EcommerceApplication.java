package com.tads.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {
    public String PORT = System.getenv("PORT");
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }
}
