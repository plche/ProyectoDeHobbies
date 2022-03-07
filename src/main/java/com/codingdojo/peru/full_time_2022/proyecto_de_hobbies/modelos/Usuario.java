package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

// La siguiente anotación indica que estamos creando una clase que representa una entidad (una tabla en SQL - bases de datos relacionales).
@Entity
// La siguinte anotación especifica la tabla con la que deseamos establecer relación/vincular.
@Table(name="usuarios")
public class Usuario {
	// La siguiente anotación señala que el campo será la clave primaria.
	@Id
	// LA siguiente anotación senala que el campo será autoincremental.
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// Ojo con la manera en que denominamos la variable, porque debería de coincidir con el mismo en la base de datos.
	// Nota: No se puede tener habilitadas ambas anotaciones, porque genera error de sintaxis...aunque volví a habilitarla y ya no arrojaba error...extraño...
	private String nombreUsuario;
	
	// La siguiente anotación señala que el campo no podrá ser nulo.
	@NotNull
	@NotEmpty
	private String nombre;
	
	@NotNull
	@NotEmpty
	private String apellido;
	
	@NotNull
	private long identificador;
	
	@NotNull
	@Size(min=4, max=60, message = "El password debe de tener entre 4 y 60 caracteres")
	private String password;

	// La anotación @OneToMany, permite crear una relación 1 a n. mappedBy, indica el campo que relaciona en Hobby.
	// FetchType.LAZY, indica que se obtendrán los datos en cuanto se accedan a ellos.
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Hobby> listaHobbies;

	public Usuario() {
	}

	public Usuario(String nombreUsuario, String nombre, String apellido, long identificador, String password) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hobby> getListaHobbies() {
		return listaHobbies;
	}

	public void setListaHobbies(List<Hobby> listaHobbies) {
		this.listaHobbies = listaHobbies;
	}
}
