/*
 * package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.controladores;
 * 
 * import org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * //La siguiente anotación se emplea para retornar strings, como JSON (en una
 * API por ejemplo), HTML, etc.
 * 
 * @RestController
 * 
 * @RequestMapping("/usuarios") public class ControladorUsuarios { public static
 * String[] usuarios = {"Alex", "Martha", "Julieta", "Alan", "Antonio"};
 * 
 * @RequestMapping(value = "", method = RequestMethod.GET) public String
 * despliegaUsuarios() { String respuesta = ""; for (int i = 0; i <
 * usuarios.length; i++) { respuesta += "<div>" + usuarios[i] + "</div>"; }
 * System.out.println(respuesta); return respuesta; }
 * 
 * @RequestMapping(value = "/filtrar", method = RequestMethod.GET) public String
 * despliegaUsuariosFiltrados(@RequestParam(value = "letra") String letra) {
 * String respuesta = ""; for (int i = 0; i < usuarios.length; i++) { if
 * (usuarios[i].toLowerCase().charAt(0) == letra.toLowerCase().charAt(0)) {
 * respuesta += "<div>" + usuarios[i] + "</div>"; } }
 * System.out.println(respuesta); return respuesta; }
 * 
 * @RequestMapping(value = "/filtrar/{letra}", method = RequestMethod.GET)
 * public String despliegaUsuariosFiltradosPath(@PathVariable("letra") String
 * letra) { String respuesta = ""; for (int i = 0; i < usuarios.length; i++) {
 * if (usuarios[i].toLowerCase().charAt(0) == letra.toLowerCase().charAt(0)) {
 * respuesta += "<div>" + usuarios[i] + "</div>"; } }
 * System.out.println(respuesta); return respuesta; } }
 */