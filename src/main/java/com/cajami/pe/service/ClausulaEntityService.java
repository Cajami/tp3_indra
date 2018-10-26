package com.cajami.pe.service;

import org.springframework.stereotype.Service;

@Service
public class ClausulaEntityService {
	private int codigoImpresion;
	private int codigoAdenda;
	private int numeroClausula;
	public ClausulaEntityService() {
		super();
	}
	public int getCodigoImpresion() {
		return codigoImpresion;
	}
	public void setCodigoImpresion(int codigoImpresion) {
		this.codigoImpresion = codigoImpresion;
	}
	public int getCodigoAdenda() {
		return codigoAdenda;
	}
	public void setCodigoAdenda(int codigoAdenda) {
		this.codigoAdenda = codigoAdenda;
	}
	public int getNumeroClausula() {
		return numeroClausula;
	}
	public void setNumeroClausula(int numeroClausula) {
		this.numeroClausula = numeroClausula;
	}
	
	

}
