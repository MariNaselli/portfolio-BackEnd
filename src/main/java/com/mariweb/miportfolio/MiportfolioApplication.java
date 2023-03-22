package com.mariweb.miportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiportfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiportfolioApplication.class, args);
        System.out.println("Iniciando la API");
    }
}