package com.cajami.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cajami.pe.service.ContratoService;

@RestController
public class ContratoClienteController {
	
	@Autowired
	private ContratoService contratoService;

	@RequestMapping(value="/getContrato",method=RequestMethod.GET)
	public ContratoService getContrato() {
		contratoService.setId(4423);
		contratoService.setApellidos("Apellidos");
		contratoService.setNombre("Nombres");
		contratoService.setEdad(31);
		return contratoService;
	}

}
