package com.restaurante.resapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ResApiApplication.class, args);
    }

    @Override
    public void run(String... arg) {
        System.out.println("EJECUTAR REPOSITORIO PARA INSERTAR AQUI");
    }
}
