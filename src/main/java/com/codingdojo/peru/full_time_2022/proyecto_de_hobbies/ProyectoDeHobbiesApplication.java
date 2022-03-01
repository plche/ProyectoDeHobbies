package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProyectoDeHobbiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDeHobbiesApplication.class, args);
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String despliegaHome() {
//		return "Hola desde Java Spring";
//	}
}
