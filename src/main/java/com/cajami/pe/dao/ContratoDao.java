package com.cajami.pe.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.cajami.pe.service.AD_BuscarContratoEntityService;
import com.cajami.pe.service.AdendaEntityService;
import com.cajami.pe.service.AnexoEntityService;
import com.cajami.pe.service.AntecedenteEntityService;
import com.cajami.pe.service.ApoderadoEntityService;
import com.cajami.pe.service.BuscarControversiaEntityService;
import com.cajami.pe.service.ClausulaEntityService;
import com.cajami.pe.service.ClienteEntityService;
import com.cajami.pe.service.ConsultarContratoService;
import com.cajami.pe.service.ConsultarControversiaEntity;
import com.cajami.pe.service.ContratoEntityService;
import com.cajami.pe.service.CronogramaEntityService;
import com.cajami.pe.service.FirmanteEntityService;
import com.cajami.pe.service.GerenteEntityService;
import com.cajami.pe.service.PagoEntityService;

public class ContratoDao {
	
ConexionDao conexion;
	
	public ContratoDao() {
		super();
		this.conexion = new ConexionDao();
	}

	public ArrayList<ClienteEntityService> recuperarClientes(int tipoBusqueda,String buscar) throws SQLException{
		
		ArrayList<ClienteEntityService> listaClientes = new ArrayList<ClienteEntityService>();
		
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_BuscarCliente(?,?) }");
			cst.setInt(1,tipoBusqueda);
			cst.setString(2,buscar );
		
			
			ResultSet resultado = cst.executeQuery();
			ClienteEntityService item;
						
			while (resultado.next()) {
				item = new ClienteEntityService();
			
				item.setCodigoFirmante(resultado.getInt("CODIGO_FIRMANTE"));
				item.setCliente(resultado.getString("Cliente"));
				item.setDireccion(resultado.getString("Direccion"));
				item.setTelefono(resultado.getString("Telefono"));
				item.setEmail(resultado.getString("Email"));
				item.setRUC(resultado.getString("RUC"));
				item.setDNI(resultado.getString("DNI"));
				item.setActividad(resultado.getString("Actividad"));
				item.setTipoCliente(resultado.getString("TipoCliente"));
								
				listaClientes.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error ==> : "+ e.getMessage());
			listaClientes = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaClientes;
	}

	public ArrayList<ContratoEntityService> recuperarContratosBusqueda(int codigoCliente, Date fechaInicio, Date fechaFin) throws SQLException{
		
		ArrayList<ContratoEntityService> listaContratos = new ArrayList<ContratoEntityService>();
		
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_BuscarContrato(?,?,?) }");
			cst.setInt(1,codigoCliente);
			cst.setDate(2,fechaInicio );
			cst.setDate(3, fechaFin );
			
			ResultSet resultado = cst.executeQuery();
			ContratoEntityService item;
						
			while (resultado.next()) {
				item = new ContratoEntityService();
			
				item.setCodigoAdenda(resultado.getInt("CODIGO_ADENDA"));
				item.setCliente(resultado.getString("CLIENTE"));
				item.setNumeroContrato(resultado.getInt("NUMERO_CONTRATO"));
				item.setNombreContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setFechaInicio(resultado.getDate("FECHA_INICIO"));
				item.setFechaFin(resultado.getDate("FECHA_FIN"));
				item.setEstadoContrato(resultado.getString("ESTADO_CONTRATO"));
				item.setEstado(resultado.getInt("ESTADO"));
								
				listaContratos.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error:  "+ e.getMessage());
			listaContratos = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaContratos;
	}

	public ArrayList<GerenteEntityService> recuperarGerentesFirmantes() throws SQLException{
		
		ArrayList<GerenteEntityService> listaGerentes= new ArrayList<GerenteEntityService>();
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_MostrarUsuarioGerente() }");
			
			ResultSet resultado = cst.executeQuery();
			GerenteEntityService item;
						
			while (resultado.next()) {
				item = new GerenteEntityService();
			
				item.setDni(resultado.getString("DNI"));
				item.setNombreApellidos(resultado.getString("APODERADO"));
								
				listaGerentes.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error:  "+ e.getMessage());
			listaGerentes = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaGerentes;
	}

	
	public ApoderadoEntityService buscarApoderadoFirmar(String dni) throws SQLException{
		ApoderadoEntityService item = null;
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_MostrarUsuarioApoderado(?) }");
			
			cst.setString(1, dni);
			
			ResultSet resultado = cst.executeQuery();
						
			if (resultado.next()) {
				item = new ApoderadoEntityService();
				item.setNombreApellidos(resultado.getString("APODERADO"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarApoderadoFirmar):  "+ e.getMessage());
			item = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return item;
	}

	public ClienteEntityService buscarClientexRucDni(String dniRuc) throws SQLException{
		ClienteEntityService item = null;
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_MostrarDatosCliente(?) }");
			cst.setString(1, dniRuc);
			ResultSet resultado = cst.executeQuery();
			if (resultado.next()) {
				item = new ClienteEntityService();
				item.setCliente(resultado.getString("CLIENTE"));
				item.setDireccion(resultado.getString("DIRECCION"));
				item.setActividad(resultado.getString("ACTIVIDAD"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarClientexRucDni):  "+ e.getMessage());
			item = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return item;
	}

	public ClienteEntityService buscarClienteFirmar(String dni) throws SQLException{
		ClienteEntityService item = null;
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_MostrarFirmanteCliente(?) }");
			
			cst.setString(1, dni);
			
			ResultSet resultado = cst.executeQuery();
						
			if (resultado.next()) {
				item = new ClienteEntityService();
				item.setDNI(resultado.getString("DNI"));
				item.setCliente(resultado.getString("CLIENTE"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarClienteFirmar):  "+ e.getMessage());
			item=null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return item;
	}

	public ContratoEntityService buscarInformacionContrato(int codigoDistrito,int tipoContrato, Date fechaInicio,String dniRucCliente	) throws SQLException{
		ContratoEntityService item = null;
				
		try {
			this.conexion.conectar();
			
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_InformacionContrato(?,?,?,?) }");
			cst.setInt(1, codigoDistrito);
			cst.setInt(2,  tipoContrato);
			cst.setDate(3, fechaInicio);
			cst.setString(4, dniRucCliente);
			
			ResultSet resultado = cst.executeQuery();
						
			if (resultado.next()) {
				item = new ContratoEntityService();
				item.setNombreContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setNumeroContrato(resultado.getInt("NRO_CONTRATO"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
			item = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return item;
	}
	
	

	public int registrarContrato(
			String dniRucCliente,
			int codigoDistrito,
			int tipoContrato,
			int codigoTipoServicio,
			String nombreContrato,
			int numeroContrato,
			String nombreProyecto,
			int tipoMoneda,
			Double montoContractual,
			Date fechaInicio,
			Date fechaFin,
			String clienteFirmante,
			String dniApoderado,
			String dniGerente,
			int numeroPagina,
			int numeroClausula) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RegistrarContrato(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

			cst.setString(1, dniRucCliente);
			cst.setInt(2, codigoDistrito );
			cst.setInt(3, tipoContrato );
			cst.setInt(4, codigoTipoServicio );
			cst.setString(5, nombreContrato);
			cst.setInt(6, numeroContrato );
			cst.setString(7, nombreProyecto);
			cst.setInt(8, tipoMoneda);
			cst.setDouble(9, montoContractual );
			cst.setDate(10, fechaInicio );
			cst.setDate(11, fechaFin );
			cst.setString(12, clienteFirmante );
			cst.setString(13, dniApoderado );
			cst.setString(14, dniGerente );
			cst.setInt(15, numeroPagina );
			cst.setInt(16, numeroClausula);
			
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public int registrarAncedente(int codigoAdenda,String descripcion) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RegistrarAntecedentes(?,?) }");
			
			cst.setInt(1, codigoAdenda);
			cst.setString(2, descripcion );
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}

	public int registrarCronograma(int codigoAdenda,int numeroEntrega,String descripcionEntrega,int cantidadDias,Date fechaEntrega) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RegistrarCronograma(?,?,?,?,?) }");
			
			cst.setInt(1, codigoAdenda);
			cst.setInt(2, numeroEntrega );
			cst.setString(3, descripcionEntrega );
			cst.setInt(4, cantidadDias );
			cst.setDate(5, fechaEntrega );
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}

	public int registrarPago(int codigoAdenda,int tipoPago,String descripcion) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RegistrarPago(?,?,?) }");
			
			cst.setInt(1, codigoAdenda);
			cst.setInt(2, tipoPago );
			cst.setString(3, descripcion );
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	

	public int registrarPagoDetalle(int codigoAdenda,int anio,int mes,int numeroCuota, Date ultimoDiaPago) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RegistrarDetPago(?,?,?,?,?) }");
			
			cst.setInt(1, codigoAdenda);
			cst.setInt(2, anio );
			cst.setInt(3, mes );
			cst.setInt(4, numeroCuota );
			cst.setDate(5, ultimoDiaPago );
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarInformacionContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public ConsultarContratoService consultarContrato(int codigoAdenda) throws SQLException {
		ConsultarContratoService consultarContrato = new ConsultarContratoService();
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_ConsultarContrato(?) }");
			
			cst.setInt(1, codigoAdenda);
			
			ResultSet rs = null;
			
			cst.execute();
			
			/*PRIMERA TABLA (DATOS DEL CONTRATO)*/
			rs = cst.getResultSet();
			
			if (rs.next()) {
				ContratoEntityService item = new ContratoEntityService();
				item.setNombrePais(rs.getString("NOMBRE_PAIS"));
				item.setNombreDepartamento(rs.getString("NOMBRE_DEPARTAMENTO"));
				item.setNombreProvincia(rs.getString("NOMBRE_PROVINCIA"));
				item.setNombreDistrito(rs.getString("NOMBRE_DISTRITO"));
				item.setTipoContrato(rs.getInt("TIPO_CONTRATO"));
				item.setNombreTipoServicio(rs.getString("NOMBRE_TIPO_SERVICIO"));
				item.setNombreContrato(rs.getString("NOMBRE_CONTRATO"));
				item.setNumeroContrato(rs.getInt("NUMERO_CONTRATO"));
				item.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));
				item.setCliente(rs.getString("CLIENTE"));
				item.setRucDni(rs.getString("RUC/DNI"));
				item.setDireccion(rs.getString("DIRECCION"));
				item.setActividad(rs.getString("ACTIVIDAD"));
				
				item.setTipoMoneda(rs.getInt("TIPO_MONEDA"));
				item.setDescripcionTipoMoneda(rs.getString("DESCRIPCION_TIPO_MONEDA"));
				item.setMontoContractual(rs.getDouble("MONTO_CONTRACTUAL"));
				item.setFechaInicio(rs.getDate("FECHA_INICIO"));
				item.setFechaFin(rs.getDate("FECHA_FIN"));
				consultarContrato.setContrato(item);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*SEGUNDA TABLA (ANTECEDENTES)*/
			rs = cst.getResultSet();
			AntecedenteEntityService itemAntecedente= null;
						
			while (rs.next()) {
				itemAntecedente =new AntecedenteEntityService();
				itemAntecedente.setDescripcion(rs.getString("DESCRIPCION_ANTECEDENTE"));
				consultarContrato.getAntecedentes().add(itemAntecedente);
			}
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*TERCERA TABLA (ANEXOS)*/
			rs = cst.getResultSet();
			AnexoEntityService itemAnexo= null;
			
			while (rs.next()) {
				itemAnexo =new AnexoEntityService();
				itemAnexo.setNumeroAnexo(rs.getInt("NUMERO_ANEXO"));
				itemAnexo.setDescripcion(rs.getString("DESCRIPCION"));
				itemAnexo.setRutaAnexo(rs.getString("RUTA_ANEXO"));
				
				consultarContrato.getAnexos().add(itemAnexo);
			}
			
			rs.close();
		
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*CUARTA TABLA (CRONOGRAMA)*/
			rs = cst.getResultSet();
			CronogramaEntityService itemCronograma = null;
			
			while (rs.next()) {
				itemCronograma =new CronogramaEntityService();
				itemCronograma.setNumeroEntrega(rs.getInt("NUMERO_ENTREGA"));
				itemCronograma.setCantidadDias(rs.getInt("CANTIDAD_DIAS"));
				itemCronograma.setFechaEntrega(rs.getDate("FECHA_ENTREGA"));
				itemCronograma.setDescripcionEntrega(rs.getString("DESCRIPCION_ENTREGA"));
				
				consultarContrato.getCronograma().add(itemCronograma);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*QUINTA TABLA (PAGOS)*/
			rs = cst.getResultSet();
			PagoEntityService itemPago = null;
			
			while (rs.next()) {
				itemPago =new PagoEntityService();
				itemPago.setTipoPago(rs.getInt("TIPO_PAGO"));
				itemPago.setNumeroCuota(rs.getInt("NUMERO_CUOTA"));
				itemPago.setAnio(rs.getInt("AÑO"));
				itemPago.setMes(rs.getInt("MES"));
				itemPago.setUltimoDiaPago(rs.getDate("ULTIMO_DIA_PAGO"));
				
				consultarContrato.getPago().add(itemPago);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*SEXTA TABLA (FIRMAS)*/
			rs = cst.getResultSet();
			FirmanteEntityService itemFirmante = null;
			
			while (rs.next()) {
				itemFirmante =new FirmanteEntityService();
				itemFirmante.setDni(rs.getString("DNI"));
				itemFirmante.setCliente(rs.getString("CLIENTE"));
				itemFirmante.setPerfil(rs.getString("PERFIL"));
				
				consultarContrato.getFirmante().add(itemFirmante);
			}
			
			rs.close();


			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (consultarContrato):  "+ e.getMessage());
			consultarContrato = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return consultarContrato;
	}
	
	public int rechazarContrato(int codigoAdenda) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_RechazarContrato(?) }");
			
			cst.setInt(1, codigoAdenda);
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (rechazarContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public int habilitarContrato(int codigoAdenda) throws SQLException {
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_HabilitarContrato(?) }");
			
			cst.setInt(1, codigoAdenda);
			
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (rechazarContrato):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	
	public ArrayList<AD_BuscarContratoEntityService> ad_BuscarContrato(int codigoCliente) throws SQLException{
		
		ArrayList<AD_BuscarContratoEntityService> listaContratos = new ArrayList<AD_BuscarContratoEntityService>();
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_AD_BuscarContrato(?) }");
			
			cst.setInt(1, codigoCliente);
			
			ResultSet resultado = cst.executeQuery();
			AD_BuscarContratoEntityService item;
						
			while (resultado.next()) {
				item = new AD_BuscarContratoEntityService();
				
				item.setCodigoContrato(resultado.getInt("CODIGO_CONTRATO"));
				item.setCodigoAdenda(resultado.getInt("CODIGO_ADENDA"));
				item.setNumeroContrato(resultado.getInt("NUMERO_CONTRATO"));
				item.setNombreContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setNumeroAdenda(resultado.getInt("NUMERO_ADENDA"));
				item.setNombreAdenda(resultado.getString("NOMBRE_ADENDA"));
				item.setNumeroSolicitud(resultado.getInt("NUMERO_SOLICITUD"));
				item.setEstadoSolicitud(resultado.getString("ESTADO_SOLICITUD"));
				item.setEstadoAdenda(resultado.getString("ESTADO_ADENDA"));
				
				listaContratos.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error:  "+ e.getMessage());
			listaContratos = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaContratos;
	}
	
	
	public ConsultarContratoService consultarAdenda(int codigoAdenda) throws SQLException {
		ConsultarContratoService consultarContrato = new ConsultarContratoService();
		int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_AD_ConsultarAdenda(?) }");
			
			cst.setInt(1, codigoAdenda);
			
			ResultSet rs = null;
			
			cst.execute();
			
			/*PRIMERA TABLA (DATOS DEL CONTRATO)*/
			rs = cst.getResultSet();
			
			if (rs.next()) {
				ContratoEntityService item = new ContratoEntityService();
				item.setNombrePais(rs.getString("NOMBRE_PAIS"));
				item.setNombreDepartamento(rs.getString("NOMBRE_DEPARTAMENTO"));
				item.setNombreProvincia(rs.getString("NOMBRE_PROVINCIA"));
				item.setNombreDistrito(rs.getString("NOMBRE_DISTRITO"));
				item.setTipoContrato(rs.getInt("TIPO_CONTRATO"));
				item.setNombreTipoServicio(rs.getString("NOMBRE_TIPO_SERVICIO"));
				item.setNombreAdenda(rs.getString("NOMBRE_ADENDA"));
				item.setNumeroAdenda(rs.getInt("NUMERO_ADENDA"));
				item.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));
				
				item.setCliente(rs.getString("CLIENTE"));
				item.setRucDni(rs.getString("RUC/DNI"));
				item.setDireccion(rs.getString("DIRECCION"));
				item.setActividad(rs.getString("ACTIVIDAD"));
				
				item.setTipoMoneda(rs.getInt("TIPO_MONEDA"));
				item.setDescripcionTipoMoneda(rs.getString("DESCRIPCION_TIPO_MONEDA"));
				item.setMontoContractual(rs.getDouble("MONTO_CONTRACTUAL"));
				item.setFechaInicio(rs.getDate("FECHA_INICIO"));
				item.setFechaFin(rs.getDate("FECHA_FIN"));
				
				item.setCodigoContrato(rs.getInt("CODIGO_CONTRATO"));
				item.setCodigoAdenda(rs.getInt("CODIGO_ADENDA"));
				item.setNombreContrato(rs.getString("NOMBRE_CONTRATO"));
				item.setNumeroContrato(rs.getInt("NUMERO_CONTRATO"));
				
				consultarContrato.setContrato(item);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*SEGUNDA TABLA (ANTECEDENTES)*/
			rs = cst.getResultSet();
			AntecedenteEntityService itemAntecedente= null;
						
			while (rs.next()) {
				itemAntecedente =new AntecedenteEntityService();
				itemAntecedente.setDescripcion(rs.getString("DESCRIPCION_ANTECEDENTE"));
				consultarContrato.getAntecedentes().add(itemAntecedente);
			}
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*TERCERA TABLA (ANEXOS)*/
			rs = cst.getResultSet();
			AnexoEntityService itemAnexo= null;
			
			while (rs.next()) {
				itemAnexo =new AnexoEntityService();
				itemAnexo.setNumeroAnexo(rs.getInt("NUMERO_ANEXO"));
				itemAnexo.setDescripcion(rs.getString("DESCRIPCION"));
				itemAnexo.setRutaAnexo(rs.getString("RUTA_ANEXO"));
				
				consultarContrato.getAnexos().add(itemAnexo);
			}
			
			rs.close();
		
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*CUARTA TABLA (CRONOGRAMA)*/
			rs = cst.getResultSet();
			CronogramaEntityService itemCronograma = null;
			
			while (rs.next()) {
				itemCronograma =new CronogramaEntityService();
				itemCronograma.setNumeroEntrega(rs.getInt("NUMERO_ENTREGA"));
				itemCronograma.setCantidadDias(rs.getInt("CANTIDAD_DIAS"));
				itemCronograma.setFechaEntrega(rs.getDate("FECHA_ENTREGA"));
				itemCronograma.setDescripcionEntrega(rs.getString("DESCRIPCION_ENTREGA"));
				
				consultarContrato.getCronograma().add(itemCronograma);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*QUINTA TABLA (PAGOS)*/
			rs = cst.getResultSet();
			PagoEntityService itemPago = null;
			
			while (rs.next()) {
				itemPago =new PagoEntityService();
				itemPago.setTipoPago(rs.getInt("TIPO_PAGO"));
				itemPago.setNumeroCuota(rs.getInt("NUMERO_CUOTA"));
				itemPago.setAnio(rs.getInt("AÑO"));
				itemPago.setMes(rs.getInt("MES"));
				itemPago.setUltimoDiaPago(rs.getDate("ULTIMO_DIA_PAGO"));
				
				consultarContrato.getPago().add(itemPago);
			}
			
			rs.close();
			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*SEXTA TABLA (FIRMAS)*/
			rs = cst.getResultSet();
			FirmanteEntityService itemFirmante = null;
			
			while (rs.next()) {
				itemFirmante =new FirmanteEntityService();
				itemFirmante.setDni(rs.getString("DNI"));
				itemFirmante.setCliente(rs.getString("CLIENTE"));
				itemFirmante.setPerfil(rs.getString("PERFIL"));
				
				consultarContrato.getFirmante().add(itemFirmante);
			}
			
			rs.close();

			
			/*NOS MOVEMOS AL SIGUIENTE RESULTADO*/
			cst.getMoreResults();
			
			/*SETIMA TABLA (CLAUSULAS)*/
			rs = cst.getResultSet();
			ClausulaEntityService itemClausula = null;
			
			while (rs.next()) {
				itemClausula =new ClausulaEntityService();
				
				itemClausula.setCodigoImpresion(rs.getInt("CODIGO_IMPRESION"));
				itemClausula.setCodigoAdenda(rs.getInt("CODIGO_ADENDA"));
				itemClausula.setNumeroClausula(rs.getInt("NUMERO_CLAUSULA"));
				
				consultarContrato.getClausula().add(itemClausula);
			}
			
			rs.close();

			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (consultarContrato):  "+ e.getMessage());
			consultarContrato = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return consultarContrato;
	}
	
	
	public AdendaEntityService informacionAdenda(int codigoContrato) throws SQLException {
		AdendaEntityService consultarAdenda = null;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_AD_InformacionAdenda(?) }");
			
			cst.setInt(1, codigoContrato);
			ResultSet resultado = cst.executeQuery();
			
			if (resultado.next()) {
				consultarAdenda = new AdendaEntityService();
				consultarAdenda.setNumeroAdenda(resultado.getInt("NUMERO_ADENDA"));
				consultarAdenda.setNombreAdenda(resultado.getString("NOMBRE_ADENDA"));
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (consultarContrato):  "+ e.getMessage());
			consultarAdenda = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return consultarAdenda;
	}
	


	public int registrarAdenda(
			int codigoContrato,
			int tipoMoneda,
			double monto,
			Date fechaInicio,
			Date fechaFin,
			String dniCliente,
			String dniApoderado,
			String dniGerente,
			int numeroPaginas,
			int numeroClausulas) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_AD_RegistrarAdenda(?,?,?,?,?,?,?,?,?,?) }");


			cst.setInt(1, codigoContrato);
			cst.setInt(2, tipoMoneda );
			cst.setDouble(3, monto );
			cst.setDate(4, fechaInicio );
			cst.setDate(5, fechaFin);
			cst.setString(6, dniCliente );
			cst.setString(7, dniApoderado);
			cst.setString(8, dniGerente);
			cst.setInt(9, numeroPaginas );
			cst.setInt(10, numeroClausulas );
			
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (registrarAdenda):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	
	public ArrayList<ContratoEntityService> buscarAdendas(int codigoCliente, Date fechaRegistro) throws SQLException{
		ArrayList<ContratoEntityService> listaAdendas = new ArrayList<ContratoEntityService>();
		ContratoEntityService item = null;
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_AD_BuscarAdenda(?,?) }");
			
			cst.setInt(1, codigoCliente);
			cst.setDate(2, fechaRegistro);
			
			ResultSet resultado = cst.executeQuery();
						
			while (resultado.next()) {
				item = new ContratoEntityService();
				item.setCodigoContrato(resultado.getInt("CODIGO_CONTRATO"));
				item.setNumeroContrato(resultado.getInt("NUMERO_CONTRATO"));
				item.setNombreContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setCodigoAdenda(resultado.getInt("CODIGO_ADENDA"));
				item.setNumeroAdenda(resultado.getInt("NUMERO_ADENDA"));
				item.setNombreAdenda(resultado.getString("NOMBRE_ADENDA"));
				item.setFechaRegistro(resultado.getDate("FECHA_REGISTRO"));
				item.setEstadoAdenda(resultado.getString("ESTADO_ADENDA"));
				
				listaAdendas.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (buscarApoderadoFirmar):  "+ e.getMessage());
			listaAdendas = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaAdendas;
	}
	

	public int modificarAdenda(
			int codigoAdenda,
			int tipoMoneda,
			double monto,
			Date fechaInicio,
			Date fechaFin,
			String dniCliente,
			String dniApoderado,
			String dniGerente,
			int numeroPaginas,
			int numeroClausulas) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_AD_ModificarAdenda(?,?,?,?,?,?,?,?,?,?) }");


			cst.setInt(1, codigoAdenda);
			cst.setInt(2, tipoMoneda );
			cst.setDouble(3, monto );
			cst.setDate(4, fechaInicio );
			cst.setDate(5, fechaFin);
			cst.setString(6, dniCliente );
			cst.setString(7, dniApoderado);
			cst.setString(8, dniGerente);
			cst.setInt(9, numeroPaginas );
			cst.setInt(10, numeroClausulas );
			
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (registrarAdenda):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	

	public int registrarClausulaImprimirAdenda(int codigoAdenda,int numeroClausula) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_AD_RegistrarImpresion(?,?) }");


			cst.setInt(1, codigoAdenda);
			cst.setInt(2, numeroClausula );
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (registrarClausulaImprimirAdenda):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}

	
	// 27-10-2018
	
	public int registrarControversia(
			int dniCliente,
			int codAdenda,
			String desControversia,
			int numeroPaginas,
			int numeroClausulas) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_CON_RegistrarControversia(?,?,?,?,?) }");


			cst.setInt(1, dniCliente);
			cst.setInt(2, codAdenda );
			cst.setString(3, desControversia);
			cst.setInt(4, numeroPaginas );
			cst.setInt(5, numeroClausulas );
			
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (registrarControversia):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}

	public int modificarControversia(
			int codControversia,
			String desControversia,
			int numeroPaginas,
			int numeroClausulas) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_CON_ModificarControversia(?,?,?,?) }");

			cst.setInt(1, codControversia );
			cst.setString(2, desControversia);
			cst.setInt(3, numeroPaginas );
			cst.setInt(4, numeroClausulas );
			
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (modificarControversia):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public int eliminarControversia(
			int codControversia) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_CON_EliminarControversia(?) }");

			cst.setInt(1, codControversia );		
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (eliminarControversia):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public int aprobarControversia(
			int codControversia) throws SQLException {			
			
			int codigoGenerado = 0;
			
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall(" { CALL SP_CON_EliminarControversia(?) }");

			cst.setInt(1, codControversia );		
						
			ResultSet rs = cst.executeQuery();
			if (rs.next()) {
				codigoGenerado = rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error (eliminarControversia):  "+ e.getMessage());
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return codigoGenerado;
	}
	
	public ArrayList<BuscarControversiaEntityService> buscarControversia(Date fechaIni,Date fechaFin, String estado, String nomContrato) throws SQLException{
		
		ArrayList<BuscarControversiaEntityService> listaControversia = new ArrayList<BuscarControversiaEntityService>();
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_CON_BuscarControversia(?,?,?,?) }");
			
			cst.setDate(1, fechaIni);
			cst.setDate(1, fechaFin);
			cst.setString(1, estado);
			cst.setString(1, nomContrato);
			
			ResultSet resultado = cst.executeQuery();
			BuscarControversiaEntityService item;
						
			while (resultado.next()) {
				item = new BuscarControversiaEntityService();
				
				item.setCodContrato(resultado.getInt("CODIGO_CONTRATO"));
				item.setCodAdenda(resultado.getInt("CODIGO_ADENDA"));
				item.setCodFirmanteControversia(resultado.getInt("firmante_controversia"));
				item.setNomContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setNomCliente(resultado.getString("CLIENTE"));
				item.setEstado(resultado.getInt("ESTADO"));
				item.setFechaRegistro(resultado.getDate("FECHA_REGISTRO"));
				item.setFechaAprobacion(resultado.getDate("FECHA_APROBACION"));
				item.setFechaUltimaMod(resultado.getDate("FECHA_ULTIMA_MODIFICACION"));
				item.setCodFirmanteContrato(resultado.getInt("firmante_contrato"));
				listaControversia.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error:  "+ e.getMessage());
			listaControversia = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaControversia;
	}
	
public ArrayList<ConsultarControversiaEntity> consultarControversia(int codControversia,int idFirmanteContrato) throws SQLException{
		
		ArrayList<ConsultarControversiaEntity> listaControversia = new ArrayList<ConsultarControversiaEntity>();
				
		try {
			this.conexion.conectar();
			CallableStatement cst = (CallableStatement) this.conexion.getCon().prepareCall("{ CALL SP_CON_ConsultarControversia(?,?) }");
			
			cst.setInt(1, codControversia);
			cst.setInt(2, idFirmanteContrato);
			
			ResultSet resultado = cst.executeQuery();
			ConsultarControversiaEntity item;
						
			while (resultado.next()) {
				item = new ConsultarControversiaEntity();
				
				item.setCodContrato(resultado.getInt("CODIGO_CONTRATO"));
				item.setCodAdenda(resultado.getInt("CODIGO_ADENDA"));
				item.setCodControversia(resultado.getInt("CODIGO_CONTROVERSIA"));
				item.setCodFirmante(resultado.getInt("cod_firmante"));
				item.setDesFirmanteContrato(resultado.getString("descripcion"));
				item.setRucFirmanteContrato(resultado.getInt("rucdni"));
				item.setNombreContrato(resultado.getString("NOMBRE_CONTRATO"));
				item.setNombreFirmante(resultado.getString("nombres"));
				item.setDniFirmante(resultado.getString("DNI"));
				item.setDirecFirmante(resultado.getString("DIRECCION"));
				item.setFonoFirmante(resultado.getString("TELEFONO"));
				item.setEmailFirmante(resultado.getString("EMAIL"));
				item.setEstadoControversia(resultado.getInt("ESTAOD"));
				item.setFechaRegistro(resultado.getDate("FECHA_REGISTRO"));
				item.setCodFirmanteContrato(resultado.getInt("cod_cliente"));
				listaControversia.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error:  "+ e.getMessage());
			listaControversia = null;
		}finally {
			if (this.conexion.getCon()!=null)
				this.conexion.desconectar();
		}
		return listaControversia;
	}
	
}
