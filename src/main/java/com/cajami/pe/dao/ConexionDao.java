package com.cajami.pe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDao {
	
	private Connection con;
	private String server,user,pass,bd;
	
	public ConexionDao() {
		this.server = "127.0.0.1";
		this.user="root";
		this.pass="taller3";
		this.bd="tp2_contratos";
	}
	
	public void conectar() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(
					"jdbc:mysql://"+this.server+"/"+this.bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					this.user, 
					this.pass
					);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("conexion: "+e.getMessage());
		}
	}
	
	public void desconectar() throws SQLException {
		this.con.close();
	}

	public Connection getCon() {
		return con;
	}


}
