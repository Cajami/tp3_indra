package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class AntecedenteEntityService {
	public String descripcion;

	public AntecedenteEntityService() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
