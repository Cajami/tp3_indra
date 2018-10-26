package com.cajami.pe.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ConsultarContratoService {
	
	public ContratoEntityService contrato;
	public ArrayList<AntecedenteEntityService> antecedentes;
	public ArrayList<AnexoEntityService> anexos;
	public ArrayList<CronogramaEntityService> cronograma;
	public ArrayList<PagoEntityService> pago;
	public ArrayList<FirmanteEntityService> firmante;
	public ArrayList<ClausulaEntityService> clausula;
	
	public ConsultarContratoService() {
		super();
		this.contrato = new ContratoEntityService();
		this.antecedentes = new ArrayList<AntecedenteEntityService>();
		this.anexos = new ArrayList<AnexoEntityService>();
		this.cronograma = new ArrayList<CronogramaEntityService>();
		this.pago = new ArrayList<PagoEntityService>();
		this.firmante = new ArrayList<FirmanteEntityService>();
		this.clausula = new ArrayList<ClausulaEntityService>();
	}
	public ContratoEntityService getContrato() {
		return contrato;
	}
	public void setContrato(ContratoEntityService contrato) {
		this.contrato = contrato;
	}
	public ArrayList<AntecedenteEntityService> getAntecedentes() {
		return antecedentes;
	}
	public void setAntecedentes(ArrayList<AntecedenteEntityService> antecedentes) {
		this.antecedentes = antecedentes;
	}
	public ArrayList<AnexoEntityService> getAnexos() {
		return anexos;
	}
	public void setAnexos(ArrayList<AnexoEntityService> anexos) {
		this.anexos = anexos;
	}
	public ArrayList<CronogramaEntityService> getCronograma() {
		return cronograma;
	}
	public void setCronograma(ArrayList<CronogramaEntityService> cronograma) {
		this.cronograma = cronograma;
	}
	public ArrayList<PagoEntityService> getPago() {
		return pago;
	}
	public void setPago(ArrayList<PagoEntityService> pago) {
		this.pago = pago;
	}
	public ArrayList<FirmanteEntityService> getFirmante() {
		return firmante;
	}
	public void setFirmante(ArrayList<FirmanteEntityService> firmante) {
		this.firmante = firmante;
	}
	public ArrayList<ClausulaEntityService> getClausula() {
		return clausula;
	}
	public void setClausula(ArrayList<ClausulaEntityService> clausula) {
		this.clausula = clausula;
	}


}
