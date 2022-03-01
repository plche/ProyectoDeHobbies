package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos.Usuario;
import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.servicios.ServicioUsuario;

//La siguiente anotación la empleamos para retornar plantillas JSP.
@Controller
@RequestMapping("/usuarios")
public class ControladorUsuario {
	
	private final ServicioUsuario servicioUsuario;

	public ControladorUsuario(ServicioUsuario servicio) {
		this.servicioUsuario = servicio;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String despliegaUsuarios(Model model, HttpSession session) {
		if (session.getAttribute("nombre") != null) {
			List<Usuario> listaUsuarios = servicioUsuario.selectAllFromUsuarios();
			model.addAttribute("listaUsuarios", listaUsuarios);
			return "usuarios.jsp";
		} else return "redirect:/usuarios/login";
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	// Agregamos la anotación @ModelAttribute para poder usar la etiqueta jstl form:form en el JSP
	public String despliegaRegistro(@ModelAttribute("usuario") Usuario nuevoUsuario) {
		return "registro.jsp";
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	// no olvidar la anotación de @Valid, sino arroja error al intentar validar
	public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario, BindingResult result) {
		
		if (result.hasErrors()) {
			// no se redirecciona, a pesar de que se trata de un POST, tenemos que enviar nuevamente el formulario para que se muestre el error de la validación
			return "registro.jsp";
		} else {
			servicioUsuario.insertIntoUsuarios(nuevoUsuario);
			
			return "redirect:/usuarios";
		}
	}
	
	@RequestMapping(value = "/eliminar/{nombreUsuario}", method = RequestMethod.DELETE)
	public String eliminarUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
		
		servicioUsuario.deleteFromUsuarios(nombreUsuario);
		
		return "redirect:/usuarios";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "nombreUsuario") String nombreUsuario,
						@RequestParam(value = "password") String password,
						HttpSession session, RedirectAttributes flash) {
		
		Usuario usuarioEncontrado = servicioUsuario.selectFromUsuariosWhereNombreUsuarioAndPassword(nombreUsuario, password);
		if (usuarioEncontrado == null) {
			if (nombreUsuario.equals("")) {
				flash.addFlashAttribute("errorNombreUsuario", "Por favor proporciona tu nombre de usuario.");
			}
			
			if (password.equals("")) {
				flash.addFlashAttribute("errorPassword", "Por favor proporciona tu contraseña.");
			}
			
			flash.addFlashAttribute("loginError", "Credenciales incorrectas.");
			
			return "redirect:/usuarios/login";
		}
		else {
			session.setAttribute("nombre", usuarioEncontrado.getNombre());
			session.setAttribute("apellido", usuarioEncontrado.getApellido());
			session.setAttribute("identificador", usuarioEncontrado.getIdentificador());
			session.setAttribute("nombreUsuario", usuarioEncontrado.getNombreUsuario());
			return "redirect:/usuarios";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("nombre");
		session.removeAttribute("apellido");
		session.removeAttribute("identificador");
		session.removeAttribute("nombreUsuario");
		return "redirect:/usuarios/login";
	}
}
