package com.cajami.pe.service;

import java.sql.Date;

public class BuscarControversiaEntityService {
	
	private int codContrato;
	private int codAdenda;
	private int codFirmanteControversia;
	private String nomContrato;
	private String nomCliente;
	private String estado;
	private String fechaRegistro;
	private String fechaAprobacion;
	private String fechaUltimaMod;
	private int codFirmanteContrato;
	
	public int getCodContrato() {
		return codContrato;
	}
	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}
	public int getCodAdenda() {
		return codAdenda;
	}
	public void setCodAdenda(int codAdenda) {
		this.codAdenda = codAdenda;
	}
	public String getNomContrato() {
		return nomContrato;
	}
	public void setNomContrato(String nomContrato) {
		this.nomContrato = nomContrato;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public String getFechaUltimaMod() {
		return fechaUltimaMod;
	}
	public void setFechaUltimaMod(String fechaUltimaMod) {
		this.fechaUltimaMod = fechaUltimaMod;
	}
	public int getCodFirmanteControversia() {
		return codFirmanteControversia;
	}
	public void setCodFirmanteControversia(int codFirmanteControversia) {
		this.codFirmanteControversia = codFirmanteControversia;
	}
	public int getCodFirmanteContrato() {
		return codFirmanteContrato;
	}
	public void setCodFirmanteContrato(int codFirmanteContrato) {
		this.codFirmanteContrato = codFirmanteContrato;
	}
	

}
