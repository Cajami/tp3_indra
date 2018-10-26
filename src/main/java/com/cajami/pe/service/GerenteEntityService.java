package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class GerenteEntityService {

	public String dni;
	public String nombreApellidos;
	public GerenteEntityService() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	

}
