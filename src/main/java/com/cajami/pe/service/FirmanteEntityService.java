package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class FirmanteEntityService {
	public int codigoFirmante;
	public String dni;
	public String cliente;
	public String perfil;
	public int estado;
	
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
	public int getCodigoFirmante() {
		return codigoFirmante;
	}
	public void setCodigoFirmante(int codigoFirmante) {
		this.codigoFirmante = codigoFirmante;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

}
