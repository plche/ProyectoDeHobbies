package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.controladores;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos.Persona;

@Controller
public class ControladorUsuariosPlantilla {
	
	public static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpSession session) {
		
		if (session.getAttribute("nombre") != null) {
			model.addAttribute("listaPersonas", listaPersonas);
			// Es posible emplear en la plantilla los datos de la sesión directamente, sin tener que pasarlos mendiante Model
			return "index.jsp";			
		} else return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "nombreUsuario") String nombreUsuario,
						@RequestParam(value = "password") String password,
						HttpSession session, RedirectAttributes flash) {
		
		if (listaPersonas.size() == 0) {
			listaPersonas.add(new Persona("Alex", "Martinez", 12345, "alex88", "pass123"));
			listaPersonas.add(new Persona("Martha", "Garcia", 67891, "martha9", "pass123"));
			listaPersonas.add(new Persona("Julieta", "Gomez", 24354, "julie27", "pass123"));
			listaPersonas.add(new Persona("Alan", "Morales", 55555, "alan12", "pass123"));
		}
		
		for (int i = 0; i < listaPersonas.size(); i++) {
			if (nombreUsuario.equals(listaPersonas.get(i).getNombreUsuario()) &&
				password.equals(listaPersonas.get(i).getPassword())) {
				session.setAttribute("nombre", listaPersonas.get(i).getNombre());
				session.setAttribute("apellido", listaPersonas.get(i).getApellido());
				session.setAttribute("identificador", listaPersonas.get(i).getIdentificador());
				session.setAttribute("nombreUsuario", listaPersonas.get(i).getNombreUsuario());
				return "redirect:/dashboard";
			}
		}
		
		if (nombreUsuario.equals("")) {
			flash.addFlashAttribute("errorNombreUsuario", "Por favor proporciona tu nombre de usuario.");
		}
		
		if (password.equals("")) {
			flash.addFlashAttribute("errorPassword", "Por favor proporciona tu contraseña.");
		}
		
		flash.addFlashAttribute("loginError", "Credenciales incorrectas.");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("nombre");
		session.removeAttribute("apellido");
		session.removeAttribute("identificador");
		session.removeAttribute("nombreUsuario");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}
}
