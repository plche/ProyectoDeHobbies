package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos.Persona;

@Controller
public class ControladorUsuariosPlantilla {
	
	public static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		if (listaPersonas.size() == 0) {
			listaPersonas.add(new Persona("Alex", "Martinez", 12345));
			listaPersonas.add(new Persona("Martha", "Garcia", 67891));
			listaPersonas.add(new Persona("Julieta", "Gomez", 24354));
			listaPersonas.add(new Persona("Alan", "Morales", 55555));
		}
		
		model.addAttribute("listaPersonas", listaPersonas);
		model.addAttribute("titulo", "Bienvenido a la aplicación de JSP con model.");
		
		return "index.jsp";
	}
}
