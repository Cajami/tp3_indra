package com.cajami.pe.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class ContratoEntityService {

	private int codigoContrato;
	private int codigoDistrito;
	private int codigoTipoServicio;
	private int codigoFirmante;
	private int tipoContrato;
	private String nombreContrato;
	private int numeroContrato;
	private String nombreProyecto;
	private Date fechaRegistro;
	
	private int codigoAdenda;
	private String cliente;
	private Date fechaInicio;
	private Date fechaFin;
	private String estadoContrato;
	private int estado;
	
	private String nombrePais;
	private String nombreDepartamento;
	private String nombreProvincia;
	private String nombreDistrito;
	private String nombreTipoServicio;
	private String rucDni;
	private String direccion;
	private String Actividad;
	
	private int tipoMoneda;
	private String descripcionTipoMoneda;
	private double montoContractual;
	
	private String nombreAdenda;
	private int numeroAdenda;
	private String estadoAdenda;
	
	private String observacion;
	private String area;
	
	private String rutaAdenda;
	
	private int codigoSolicitud;
	private int numeroSolicitud;
	private String estadoSolicitud;
	
	private int codigoControversia;
					
	public int getCodigoControversia() {
		return codigoControversia;
	}

	public void setCodigoControversia(int codigoControversia) {
		this.codigoControversia = codigoControversia;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public int getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(int codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getRutaAdenda() {
		return rutaAdenda;
	}

	public void setRutaAdenda(String rutaAdenda) {
		this.rutaAdenda = rutaAdenda;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ContratoEntityService() {
		super();
	}

	public int getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(int codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public int getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public int getCodigoTipoServicio() {
		return codigoTipoServicio;
	}

	public void setCodigoTipoServicio(int codigoTipoServicio) {
		this.codigoTipoServicio = codigoTipoServicio;
	}

	public int getCodigoFirmante() {
		return codigoFirmante;
	}

	public void setCodigoFirmante(int codigoFirmante) {
		this.codigoFirmante = codigoFirmante;
	}

	public int getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(int tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getNombreContrato() {
		return nombreContrato;
	}

	public void setNombreContrato(String nombreContrato) {
		this.nombreContrato = nombreContrato;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getCodigoAdenda() {
		return codigoAdenda;
	}

	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstadoContrato() {
		return estadoContrato;
	}

	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRucDni() {
		return rucDni;
	}

	public void setRucDni(String rucDni) {
		this.rucDni = rucDni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	public int getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(int tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getDescripcionTipoMoneda() {
		return descripcionTipoMoneda;
	}

	public void setDescripcionTipoMoneda(String descripcionTipoMoneda) {
		this.descripcionTipoMoneda = descripcionTipoMoneda;
	}

	public double getMontoContractual() {
		return montoContractual;
	}

	public void setMontoContractual(double montoContractual) {
		this.montoContractual = montoContractual;
	}

	public String getNombreAdenda() {
		return nombreAdenda;
	}

	public void setNombreAdenda(String nombreAdenda) {
		this.nombreAdenda = nombreAdenda;
	}

	public int getNumeroAdenda() {
		return numeroAdenda;
	}

	public void setNumeroAdenda(int numeroAdenda) {
		this.numeroAdenda = numeroAdenda;
	}

	public String getEstadoAdenda() {
		return estadoAdenda;
	}

	public void setEstadoAdenda(String estadoAdenda) {
		this.estadoAdenda = estadoAdenda;
	}

}
