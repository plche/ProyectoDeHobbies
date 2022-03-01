package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos.Usuario;

//La siguiente anotación indica que estamos creando una clase que representa un repositorio (en SQL - bases de datos relacionales).
@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{
	// SELECT * FROM usuarios
	List<Usuario> findAll();
	
	// INSERT INTO usuarios(nombre_usuario, nombre, apellido, indetificador, password)
	// VALUES (Objeto con todos los datos)
	@SuppressWarnings("unchecked")
	Usuario save(Usuario nuevoUsuario);
	
	// DELETE FROM usuarios WHERE nombre_usuario = nombreUsuario
	@Transactional
	Long deleteByNombreUsuario(String nombreUsuario);
	
	List<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario, String password);
}
