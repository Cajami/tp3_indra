package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class AdendaEntityService {

	private int codigoAdenda;
	private int numeroAdenda;
	private String nombreAdenda;
	public AdendaEntityService() {
		super();
	}
	public int getCodigoAdenda() {
		return codigoAdenda;
	}
	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}
	public int getNumeroAdenda() {
		return numeroAdenda;
	}
	public void setNumeroAdenda(int numeroAdenda) {
		this.numeroAdenda = numeroAdenda;
	}
	public String getNombreAdenda() {
		return nombreAdenda;
	}
	public void setNombreAdenda(String nombreAdenda) {
		this.nombreAdenda = nombreAdenda;
	}

}
