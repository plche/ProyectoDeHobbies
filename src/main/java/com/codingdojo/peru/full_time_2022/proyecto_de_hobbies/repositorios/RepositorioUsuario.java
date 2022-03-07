package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	@Transactional
	@Modifying
	@Query(value = "UPDATE usuarios SET nombre = ?1, apellido = ?2, password = ?3, identificador = ?4 " +
			"WHERE nombre_usuario = ?5", nativeQuery = true)
	void actualizarUsuario(String nombre, String apellido, String password, Long identificador, String nombreUsuario);

	@Transactional
	@Modifying
	@Query(value = "UPDATE usuarios SET nombre = :nombre, apellido = :apellido, password = :password, identificador = :identificador " +
			"WHERE nombre_usuario = :nombreUsuario", nativeQuery = true)
	void actualizarUsuarioOpcion2(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("password") String password,
								  @Param("identificador") Long identificador, @Param("nombreUsuario") String nombreUsuario);
}
