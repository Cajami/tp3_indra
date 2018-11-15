package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class AD_BuscarContratoEntityService {

	private int codigoContrato;
	private int codigoAdenda;
	private int numeroContrato;
	private String nombreContrato;
	private int numeroAdenda;
	private String nombreAdenda;
	private int numeroSolicitud;
	private String estadoSolicitud;
	private String estadoAdenda;
	private int codigoControversia;
	
	
	public AD_BuscarContratoEntityService() {
		super();
	}
	
	public int getCodigoControversia() {
		return codigoControversia;
	}



	public void setCodigoControversia(int codigoControversia) {
		this.codigoControversia = codigoControversia;
	}



	public int getCodigoContrato() {
		return codigoContrato;
	}
	public void setCodigoContrato(int codigoContrato) {
		this.codigoContrato = codigoContrato;
	}
	public int getCodigoAdenda() {
		return codigoAdenda;
	}
	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}
	public int getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getNombreContrato() {
		return nombreContrato;
	}
	public void setNombreContrato(String nombreContrato) {
		this.nombreContrato = nombreContrato;
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
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getEstadoAdenda() {
		return estadoAdenda;
	}
	public void setEstadoAdenda(String estadoAdenda) {
		this.estadoAdenda = estadoAdenda;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

}
