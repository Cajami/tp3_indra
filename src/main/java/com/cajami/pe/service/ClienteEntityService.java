package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class ClienteEntityService {

	private int CodigoFirmante;
	private String Cliente;
	private String Direccion;
	private String Telefono;
	private String Email;
	private String RUC;
	private String DNI;
	private String Actividad;
	private String TipoCliente;
	
	public ClienteEntityService() {
		super();
	}

	public int getCodigoFirmante() {
		return CodigoFirmante;
	}

	public void setCodigoFirmante(int codigoFirmante) {
		CodigoFirmante = codigoFirmante;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	public String getTipoCliente() {
		return TipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}

}
