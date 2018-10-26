package com.cajami.pe.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class CronogramaEntityService {

	public int codigoCronograma;
	public int codigoAdenda;
	public int numeroEntrega;
	public String descripcionEntrega;
	public int cantidadDias;
	public Date fechaEntrega;
	public Date fechaRegistro;
	public Date fechaUltimaModificacion;
	
	public CronogramaEntityService() {
		super();
	}

	public int getCodigoCronograma() {
		return codigoCronograma;
	}

	public void setCodigoCronograma(int codigoCronograma) {
		this.codigoCronograma = codigoCronograma;
	}

	public int getCodigoAdenda() {
		return codigoAdenda;
	}

	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}

	public int getNumeroEntrega() {
		return numeroEntrega;
	}

	public void setNumeroEntrega(int numeroEntrega) {
		this.numeroEntrega = numeroEntrega;
	}

	public String getDescripcionEntrega() {
		return descripcionEntrega;
	}

	public void setDescripcionEntrega(String descripcionEntrega) {
		this.descripcionEntrega = descripcionEntrega;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

}
