package com.mariweb.miportfolio;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiportfolioApplication {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(MiportfolioApplication.class, args);
        System.out.println("Iniciando la API");
    }

    @PostConstruct
    public void init() {
        System.out.println("La URL de la base de datos es: " + dbUrl);
    }
}
