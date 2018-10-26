package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class ApoderadoEntityService {

	public String nombreApellidos;

	public ApoderadoEntityService() {
		super();
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	
	

}
