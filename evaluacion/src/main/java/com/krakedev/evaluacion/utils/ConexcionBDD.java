package com.krakedev.evaluacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakedevException;


public class ConexcionBDD {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";
	private static final Logger LOGGER = LogManager.getFormatterLogger(ConexcionBDD.class);


	// si convierto un metodo en estatico las constante que use dentro de ese metodo
	// tambien deben ser estaticas
	public static Connection conectar()  throws KrakedevException { //debeo especificar en la firma del metodo que voy a lanza runa expection
		Connection connetion = null;
		try {
			Class.forName(DRIVER);
			connetion = DriverManager.getConnection(URL, USER, PASSWORD);
			LOGGER.debug("Obteniendo conexcion");
		} catch (ClassNotFoundException e) {
			LOGGER.debug("Error en la infraestructura", e);
			//relanzando una excepcition 
			throw new KrakedevException("Error en la infraestructura");
		} catch (SQLException e) {
			LOGGER.error("No logro conectarse, revise usuario y clave", e);
			throw new KrakedevException("No logro conectarse, revise usuario y clave");

		}
		return connetion;
	}

}
