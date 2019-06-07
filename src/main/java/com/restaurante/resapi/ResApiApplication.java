package com.restaurante.resapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SpringBootApplication
public class ResApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ResApiApplication.class, args);
    }

    @Override
    public void run(String... arg) {
        System.out.println("EJECUTAR REPOSITORIO PARA INSERTAR AQUI");
        LocalDateTime ldt = LocalDateTime.now();
        String fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
        System.out.println(fecha);

    }
}
