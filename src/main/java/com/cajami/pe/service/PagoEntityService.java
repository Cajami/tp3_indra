package com.cajami.pe.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class PagoEntityService {

	public int tipoPago;
	public int numeroCuota;
	public int anio;
	public int mes;
	public Date ultimoDiaPago;
	public PagoEntityService() {
		super();
	}
	public int getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public Date getUltimoDiaPago() {
		return ultimoDiaPago;
	}
	public void setUltimoDiaPago(Date ultimoDiaPago) {
		this.ultimoDiaPago = ultimoDiaPago;
	}

}
