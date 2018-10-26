package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class FirmanteEntityService {
	public String dni;
	public String cliente;
	public String perfil;
	public FirmanteEntityService() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
