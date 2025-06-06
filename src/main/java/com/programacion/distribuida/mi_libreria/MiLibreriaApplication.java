package com.programacion.distribuida.mi_libreria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiLibreriaApplication  implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(MiLibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mi Librería está corriendo...");
	}
}
