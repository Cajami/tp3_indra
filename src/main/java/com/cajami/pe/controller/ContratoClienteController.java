package com.cajami.pe.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cajami.pe.dao.ContratoDao;
import com.cajami.pe.service.AD_BuscarContratoEntityService;
import com.cajami.pe.service.AdendaEntityService;
import com.cajami.pe.service.ApoderadoEntityService;
import com.cajami.pe.service.ClienteEntityService;
import com.cajami.pe.service.ConsultarContratoService;
import com.cajami.pe.service.ConsultarControversiaEntity;
import com.cajami.pe.service.ContratoEntityService;
import com.cajami.pe.service.ContratoService;
import com.cajami.pe.service.BuscarControversiaEntityService;
import com.cajami.pe.service.GerenteEntityService;

@RestController
@RequestMapping("/indraupc")
public class ContratoClienteController {
	
	@SuppressWarnings("deprecation")
	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedOrigins("*");
	            }
	        };
	    }
	 
	
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

	//    @GetMapping("/greeting")

    //public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {

	@RequestMapping(
			value="/validarContrato",
			method=RequestMethod.POST
			//params = {"primerMensaje", "segundoMensaje"}
	)
	//	public ArrayList<ClienteEntity> buscarCliente(@FormParam ("tipoBusqueda") int tipoBusqueda,@FormParam("buscar") String buscar) throws SQLException {
//@RequestParam(value = "_search") String search, 

	public String  validarContrato(
			@RequestParam(required=true) String primerMensaje, 
			@RequestParam(required=true) String segundoMensaje) throws SQLException {
		

    	//ArrayList<ContratoEntity>
    	//Conexion c = new Conexion();
		//vo.setUsuario("javier");
		//vo.setPassword("prueba");
		//vo.setUserValido(true);
    	//ArrayList<VOUsuario> lista  = c.getDatosSP();
    	return "Esto es un servicio rest: "+ primerMensaje + " : " + segundoMensaje;
	}
    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/buscarCliente",method=RequestMethod.POST)
	public ArrayList<ClienteEntityService> buscarCliente(@RequestParam(required=true) int tipoBusqueda, @RequestParam(required=true) String buscar) throws SQLException {
    	return new ContratoDao().recuperarClientes(tipoBusqueda, buscar);
	}
    
	@RequestMapping(value="/buscarContratos",method=RequestMethod.POST)
	public ArrayList<ContratoEntityService> buscarContratos(@RequestParam(required=true) int codigoCliente, @RequestParam(required=true) Date fechaInicio, @RequestParam(required=true) Date fechaFin) throws SQLException {
    	return new ContratoDao().recuperarContratosBusqueda(codigoCliente, fechaInicio, fechaFin);
	}
        
	@RequestMapping(value="/buscarGerentesFirmantes",method=RequestMethod.POST)
	public ArrayList<GerenteEntityService> buscarGerentesFirmantes() throws SQLException {
    	return new ContratoDao().recuperarGerentesFirmantes();
	}
    
	@RequestMapping(value="/buscarApoderado",method=RequestMethod.POST)
	public ApoderadoEntityService buscarApoderado(@RequestParam(required=true) String dni) throws SQLException {
    	return new ContratoDao().buscarApoderadoFirmar(dni);
	}    

	@RequestMapping(value="/buscarClientexRucDni",method=RequestMethod.POST)
	public ClienteEntityService buscarClientexRucDni(@RequestParam(required=true) String dniRuc) throws SQLException {
    	return new ContratoDao().buscarClientexRucDni(dniRuc);
	}
    
	@RequestMapping(value="/buscarClienteFirmar",method=RequestMethod.POST)
	public ClienteEntityService buscarClienteFirmar(@RequestParam(required=true) String dni) throws SQLException {
    	return new ContratoDao().buscarClienteFirmar(dni);
	}
    
	@RequestMapping(value="/buscarInformacionContrato",method=RequestMethod.POST)
	public ContratoEntityService buscarInformacionContrato(@RequestParam(required=true) int codigoDistrito, @RequestParam(required=true) int tipoContrato, @RequestParam(required=true) Date fechaInicio, @RequestParam(required=true) String dniRucCliente) throws SQLException {
    	System.err.println("llegó al servicio");
    	return new ContratoDao().buscarInformacionContrato(codigoDistrito,tipoContrato,fechaInicio,dniRucCliente);
	}
        
	@RequestMapping(value="/registrarContrato",method=RequestMethod.POST)
	public int registrarContrato(
			@RequestParam(required=true) String dniRucCliente,
			@RequestParam(required=true) int codigoDistrito,
			@RequestParam(required=true) int tipoContrato,
			@RequestParam(required=true) int codigoTipoServicio,
			@RequestParam(required=true) String nombreContrato,
			@RequestParam(required=true) int numeroContrato,
			@RequestParam(required=true) String nombreProyecto,
			@RequestParam(required=true) int tipoMoneda,
			@RequestParam(required=true) Double montoContractual,
			@RequestParam(required=true) Date fechaInicio,
			@RequestParam(required=true) Date fechaFin,
			@RequestParam(required=true) String clienteFirmante,
			@RequestParam(required=true) String dniApoderado,
			@RequestParam(required=true) String dniGerente,
			@RequestParam(required=true) int numeroPagina,
			@RequestParam(required=true) int numeroClausula) throws SQLException {
    	
    	return new ContratoDao().registrarContrato(
    			dniRucCliente,
    			codigoDistrito,
    			tipoContrato,
    			codigoTipoServicio,
    			nombreContrato,
    			numeroContrato,
    			nombreProyecto,
    			tipoMoneda,
    			montoContractual,
    			fechaInicio,
    			fechaFin,
    			clienteFirmante,
    			dniApoderado,
    			dniGerente,
    			numeroPagina,
    			numeroClausula);
	}
    
	@RequestMapping(value="/registrarAncedente",method=RequestMethod.POST)
	public int registrarAncedente(@RequestParam(required=true) int codigoAdenda, @RequestParam(required=true) String descripcion) throws SQLException {
    	return new ContratoDao().registrarAncedente(codigoAdenda,descripcion);
	}

    
	@RequestMapping(value="/registrarCronograma",method=RequestMethod.POST)
	public int registrarCronograma(
			@RequestParam(required=true) int codigoAdenda,
			@RequestParam(required=true) int numeroEntrega,
			@RequestParam(required=true) String descripcionEntrega,
			@RequestParam(required=true) int cantidadDias,
			@RequestParam(required=true) Date fechaEntrega) throws SQLException {
    	return new ContratoDao().registrarCronograma(codigoAdenda,numeroEntrega,descripcionEntrega,cantidadDias,fechaEntrega);
	}

    
	@RequestMapping(value="/registrarPago",method=RequestMethod.POST)
	public int registrarPago(@RequestParam(required=true) int codigoAdenda, @RequestParam(required=true) int tipoPago, @RequestParam(required=true) String descripcion) throws SQLException {
    	return new ContratoDao().registrarPago(codigoAdenda,tipoPago,descripcion);
	}

    
	@RequestMapping(value="/registrarPagoDetalle",method=RequestMethod.POST)
	public int registrarPagoDetalle(@RequestParam(required=true) int codigoAdenda, @RequestParam(required=true) int anio, @RequestParam(required=true) int mes, @RequestParam(required=true) int numeroCuota, @RequestParam(required=true) Date ultimoDiaPago) throws SQLException {
    	return new ContratoDao().registrarPagoDetalle(codigoAdenda,anio,mes,numeroCuota,ultimoDiaPago);
	}

	@RequestMapping(value="/consultarContrato",method=RequestMethod.POST)
	public ConsultarContratoService consultarContrato(@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().consultarContrato(codigoAdenda);
	}
	
	@RequestMapping(value="/rechazarContrato",method=RequestMethod.POST)
	public int rechazarContrato(@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().rechazarContrato(codigoAdenda);
	}

	@RequestMapping(value="/habilitarContrato",method=RequestMethod.POST)
	public int habilitarContrato(@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().habilitarContrato(codigoAdenda);
	}
    
	@RequestMapping(value="/ad_BuscarContrato",method=RequestMethod.POST)
	public ArrayList<AD_BuscarContratoEntityService> ad_BuscarContrato(@RequestParam(required=true) int codigoCliente) throws SQLException {
    	return new ContratoDao().ad_BuscarContrato(codigoCliente);
	}
    
	
	@RequestMapping(value="/ad_ConsultarAdenda",method=RequestMethod.POST)
	public ConsultarContratoService ad_ConsultarAdenda(@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().consultarAdenda(codigoAdenda);
	}
	

	@RequestMapping(value="/informacionAdenda",method=RequestMethod.POST)
	public AdendaEntityService informacionAdenda(@RequestParam(required=true) int codigoContrato) throws SQLException {
    	return new ContratoDao().informacionAdenda(codigoContrato);
	}


	@RequestMapping(value="/registrarAdenda",method=RequestMethod.POST)
	public int registrarAdenda(
			@RequestParam(required=true) int codigoContrato,
			@RequestParam(required=true) int tipoMoneda,
			@RequestParam(required=true) double monto,
			@RequestParam(required=true) Date fechaInicio,
			@RequestParam(required=true) Date fechaFin,
			@RequestParam(required=true) String dniCliente,
			@RequestParam(required=true) String dniApoderado,
			@RequestParam(required=true) String dniGerente,
			@RequestParam(required=true) int numeroPaginas,
			@RequestParam(required=true) int numeroClausulas) throws SQLException {
    	return new ContratoDao().registrarAdenda(codigoContrato,tipoMoneda,monto,fechaInicio,fechaFin,dniCliente,dniApoderado,dniGerente,numeroPaginas,numeroClausulas);
	}
	
	@RequestMapping(value="/buscarAdendas",method=RequestMethod.POST)
	public ArrayList<ContratoEntityService> buscarAdendas(@RequestParam(required=true) int codigoCliente, @RequestParam(required=true) Date fechaRegistro) throws SQLException {
    	return new ContratoDao().buscarAdendas(codigoCliente,fechaRegistro);
	}
	
	@RequestMapping(value="/modificarAdenda",method=RequestMethod.POST)
	public int modificarAdenda(
			@RequestParam(required=true) int codigoAdenda,
			@RequestParam(required=true) int tipoMoneda,
			@RequestParam(required=true) double monto,
			@RequestParam(required=true) Date fechaInicio,
			@RequestParam(required=true) Date fechaFin,
			@RequestParam(required=true) String dniCliente,
			@RequestParam(required=true) String dniApoderado,
			@RequestParam(required=true) String dniGerente,
			@RequestParam(required=true) int numeroPaginas,
			@RequestParam(required=true) int numeroClausulas) throws SQLException {
    	return new ContratoDao().modificarAdenda(codigoAdenda,tipoMoneda,monto,fechaInicio,fechaFin,dniCliente,dniApoderado,dniGerente,numeroPaginas,numeroClausulas);
	}

	@RequestMapping(value="/registrarClausulaImprimirAdenda",method=RequestMethod.POST)
	public int registrarClausulaImprimirAdenda(@RequestParam(required=true) int codigoAdenda, @RequestParam(required=true) int numeroClausula) throws SQLException {
    	return new ContratoDao().registrarClausulaImprimirAdenda(codigoAdenda,numeroClausula);
	}
	
	
	// 27-10-2018
	
	@RequestMapping(value="/registrarControversia",method=RequestMethod.POST)
	public int registrarControversia(
			@RequestParam(required=true) int dniCliente,
			@RequestParam(required=true) int codAdenda,
			@RequestParam(required=true) String desControversia,
			@RequestParam(required=true) int numeroPaginas,
			@RequestParam(required=true) int numeroClausulas) throws SQLException {
    	return new ContratoDao().registrarControversia(dniCliente,codAdenda,desControversia,numeroPaginas,numeroClausulas);
	}
	
	@RequestMapping(value="/modificarControversia",method=RequestMethod.POST)
	public int modificarControversia(
			@RequestParam(required=true) int codControversia,
			@RequestParam(required=true) String desControversia,
			@RequestParam(required=true) int numeroPaginas,
			@RequestParam(required=true) int numeroClausulas) throws SQLException {
    	return new ContratoDao().modificarControversia(codControversia,desControversia,numeroPaginas,numeroClausulas);
	}
	
	@RequestMapping(value="/eliminarControversia",method=RequestMethod.POST)
	public int eliminarControversia(
			@RequestParam(required=true) int codControversia) throws SQLException {
    	return new ContratoDao().eliminarControversia(codControversia);
	}
	
	@RequestMapping(value="/aprobarControversia",method=RequestMethod.POST)
	public int aprobarControversia(
			@RequestParam(required=true) int codControversia) throws SQLException {
    	return new ContratoDao().aprobarControversia(codControversia);
	}
	
	@RequestMapping(value="/buscarControversia",method=RequestMethod.POST)
	public ArrayList<BuscarControversiaEntityService> buscarControversia(
			@RequestParam(required=true) String estado,
			@RequestParam(required=true) String nomContrato) throws SQLException {
    	return new ContratoDao().buscarControversia(estado,nomContrato);
	}
	
	@RequestMapping(value="/consultarControversia",method=RequestMethod.POST)
	public ArrayList<ConsultarControversiaEntity> consultarControversia(
			@RequestParam(required=true) int codControversia,
			@RequestParam(required=true) int idFirmanteContrato) throws SQLException {
    	return new ContratoDao().consultarControversia(codControversia,idFirmanteContrato);
	}
	
	@RequestMapping(value="/buscarxContAdenda",method=RequestMethod.POST)
	public ArrayList<ConsultarControversiaEntity> buscarxContAdenda(
			@RequestParam(required=true) int codContrato,
			@RequestParam(required=true) int codAdenda) throws SQLException {
    	return new ContratoDao().buscarxContAdenda(codContrato,codAdenda);
	}
	
	@RequestMapping(value="/buscarFirmasAdendas",method=RequestMethod.POST)
	public ArrayList<ContratoEntityService> buscarFirmasAdendas(
			@RequestParam(required=true) int codCliente,
			@RequestParam(required=true) int codUsuario) throws SQLException {

	
    	return new ContratoDao().buscarFirmasAdendas(codCliente,codUsuario);
	}
	
	
	@RequestMapping(value="/seleccionarFirmaAdenda",method=RequestMethod.POST)
	public ConsultarContratoService seleccionarFirmaAdenda(
			@RequestParam(required=true) int codAdenda) throws SQLException {
	
    	return new ContratoDao().seleccionarFirmaAdenda(codAdenda);
	}
	
	@RequestMapping(value="/firmarContratoAdenda",method=RequestMethod.POST)
	public int firmarContratoAdenda(
			@RequestParam(required=true) int codAdenda,
			@RequestParam(required=true) int codUsuario,
			@RequestParam(required=true) int opcionCliente) throws SQLException {
    	return new ContratoDao().firmarContratoAdenda(codAdenda,codUsuario,opcionCliente);
	}

	@RequestMapping(value="/observarAdendaFirmar",method=RequestMethod.POST)
	public int observarAdendaFirmar(
			@RequestParam(required=true) int codAdenda,
			@RequestParam(required=true) int codUsuario,
			@RequestParam(required=true) String observacion) throws SQLException {
	
    	return new ContratoDao().observarAdendaFirmar(codAdenda,codUsuario,observacion);
	}


	

	@RequestMapping(value="/guardarFirmaContratoAdenda",method=RequestMethod.POST)
	public int guardarFirmaContratoAdenda(
			@RequestParam(required=true) int codAdenda,
			@RequestParam(required=true) @ModelAttribute MultipartFile documento) throws SQLException {
	
    	return new ContratoDao().guardarFirmaContratoAdenda(codAdenda,documento);
	}
	
	@RequestMapping(value="/buscarSolicitudCambios",method=RequestMethod.POST)
	public ArrayList<ContratoEntityService> buscarSolicitudCambios(
			@RequestParam(required=true) int codigoCliente, 
			@RequestParam(required=true) Date fechaRegistro) throws SQLException {
    	return new ContratoDao().buscarSolicitudCambios(codigoCliente, fechaRegistro);
	}

	@RequestMapping(value="/seleccionarAdendaSolicitudCambios",method=RequestMethod.POST)
	public ContratoEntityService seleccionarAdendaSolicitudCambios(
			@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().seleccionarAdendaSolicitudCambios(codigoAdenda);
	}
    
	@RequestMapping(value="/registrarSolicitudCambios",method=RequestMethod.POST)
	public int registrarSolicitudCambios(
			@RequestParam(required=true) int codigoAdenda) throws SQLException {
    	return new ContratoDao().registrarSolicitudCambios(codigoAdenda);
	}
	
	@RequestMapping(value="/registrarClausulaSolicitudCambios",method=RequestMethod.POST)
	public int registrarClausulaSolicitudCambios(
			@RequestParam(required=true) int codigoSolicitud,
			@RequestParam(required=true) int numeroClausula,
			@RequestParam(required=true) String detalle) throws SQLException {
    	return new ContratoDao().registrarClausulaSolicitudCambios(codigoSolicitud,numeroClausula,detalle);
	}
	
	
	@RequestMapping(value="/consultarSolicitudCambio",method=RequestMethod.POST)
	public ConsultarContratoService consultarSolicitudCambio(
			@RequestParam(required=true) int codigoSolicitud) throws SQLException {
    	return new ContratoDao().consultarSolicitudCambio(codigoSolicitud);
	}
	
	@RequestMapping(value="/modificarSolicitudCambio",method=RequestMethod.POST)
	public int modificarSolicitudCambio(
			@RequestParam(required=true) int codigoSolicitud) throws SQLException {
    	return new ContratoDao().modificarSolicitudCambio(codigoSolicitud);
	}
	
	@RequestMapping(value="/eliminarSolicitudCambio",method=RequestMethod.POST)
	public int eliminarSolicitudCambio(
			@RequestParam(required=true) int codigoSolicitud) throws SQLException {
    	return new ContratoDao().eliminarSolicitudCambio(codigoSolicitud);
	}
	
	
	@RequestMapping(value="/aprobarSolicitudCambio",method=RequestMethod.POST)
	public int aprobarSolicitudCambio(
			@RequestParam(required=true) int codigoSolicitud) throws SQLException {
    	return new ContratoDao().aprobarSolicitudCambio(codigoSolicitud);
	}	
	
	
	
	
	//SP_SC_ConsultarSolicitudCambios
	
}







