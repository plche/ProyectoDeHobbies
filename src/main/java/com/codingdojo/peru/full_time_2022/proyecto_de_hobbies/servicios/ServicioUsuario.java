package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos.Usuario;
import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.repositorios.RepositorioUsuario;

//La siguiente anotación indica que estamos creando una clase que representa un servicio (en SQL - bases de datos relacionales).
@Service
public class ServicioUsuario {
	private final RepositorioUsuario repositorioUsuario;

	public ServicioUsuario(RepositorioUsuario repositorio) {
		this.repositorioUsuario = repositorio;
	}
	
	public List<Usuario> selectAllFromUsuarios() {
		return repositorioUsuario.findAll();
	}
	
	public Usuario insertIntoUsuarios(Usuario nuevoUsuario) {
		return repositorioUsuario.save(nuevoUsuario);
	}
	
	public Long deleteFromUsuarios(String nombreUsuario) {
		return repositorioUsuario.deleteByNombreUsuario(nombreUsuario);
	}
	
	public Usuario selectFromUsuariosWhereNombreUsuarioAndPassword( String nombreUsuario, String password) {
		List<Usuario> usuarioEncontrado = repositorioUsuario.findByNombreUsuarioAndPassword(nombreUsuario, password);
		if (usuarioEncontrado.isEmpty()) return null;
		else return usuarioEncontrado.get(0);
	}

	public void updateUsuario(Usuario editarUsuario) {
//		repositorioUsuario.actualizarUsuario(editarUsuario.getNombre(), editarUsuario.getApellido(), editarUsuario.getPassword(),
//				editarUsuario.getIdentificador(), editarUsuario.getNombreUsuario());
		repositorioUsuario.actualizarUsuarioOpcion2(editarUsuario.getNombre(), editarUsuario.getApellido(), editarUsuario.getPassword(),
				editarUsuario.getIdentificador(), editarUsuario.getNombreUsuario());
	}
}
