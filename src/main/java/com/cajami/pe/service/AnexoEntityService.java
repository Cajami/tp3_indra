package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class AnexoEntityService {
	public int codigoAnexo;
	public int codigoAdenda;
	public int numeroAnexo;
	public String descripcion;
	public String rutaAnexo;
	
	public AnexoEntityService() {
		super();
	}

	public int getCodigoAnexo() {
		return codigoAnexo;
	}

	public void setCodigoAnexo(int codigoAnexo) {
		this.codigoAnexo = codigoAnexo;
	}

	public int getCodigoAdenda() {
		return codigoAdenda;
	}

	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}

	public int getNumeroAnexo() {
		return numeroAnexo;
	}

	public void setNumeroAnexo(int numeroAnexo) {
		this.numeroAnexo = numeroAnexo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaAnexo() {
		return rutaAnexo;
	}

	public void setRutaAnexo(String rutaAnexo) {
		this.rutaAnexo = rutaAnexo;
	}

}
