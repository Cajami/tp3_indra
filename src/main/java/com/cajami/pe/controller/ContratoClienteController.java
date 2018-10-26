package com.cajami.pe.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cajami.pe.service.ContratoService;

@RestController
public class ContratoClienteController {
	
	@Autowired
	private ContratoService contratoService;

	@RequestMapping(value="/getContrato",method=RequestMethod.GET)
	public String getContrato() {
		contratoService.setId(4423);
		contratoService.setApellidos("Apellidos");
		contratoService.setNombre("Nombres");
		contratoService.setEdad(31);
		//return contratoService;
		return "este es un nuevo correo";
	}
	
	
//    @POST
//    @Path("/validarContrato")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({MediaType.APPLICATION_JSON})
	@RequestMapping(
			value="/validarContrato",
			method=RequestMethod.POST,
			params = {"primerMensaje", "segundoMensaje"}
	)
	//	public ArrayList<ClienteEntity> buscarCliente(@FormParam ("tipoBusqueda") int tipoBusqueda,@FormParam("buscar") String buscar) throws SQLException {
//@RequestParam(value = "_search") String search, 

	public String  validarContrato(
			@RequestParam(value = "defecto1") String primerMensaje, 
			@RequestParam(value = "defecto2") String segundoMensaje) throws SQLException {
		

    	//ArrayList<ContratoEntity>
    	//Conexion c = new Conexion();
		//vo.setUsuario("javier");
		//vo.setPassword("prueba");
		//vo.setUserValido(true);
    	//ArrayList<VOUsuario> lista  = c.getDatosSP();
    	return "Esto es un servicio rest: "+ primerMensaje + " : " + segundoMensaje;
	}
    

	
}
