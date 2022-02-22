package com.codingdojo.peru.full_time_2022.proyecto_de_hobbies.modelos;

public class Persona {
	private String nombre;
	private String apellido;
	private long identificador;
	
	public Persona(String nombre, String apellido, long identificador) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificador = identificador;
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
}
