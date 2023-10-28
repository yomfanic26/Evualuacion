package com.krakedev.evaluacion.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakedevException;
import com.krakedev.evaluacion.utils.ConexcionBDD;

public class TestConexionBDD {
	private static final Logger LOGGER = LogManager.getFormatterLogger(TestConexionBDD.class);

	public static void main(String[] args) throws KrakedevException {
		Connection con = null;

		try {
			// abriendo conexcionS
			con = ConexcionBDD.conectar();
			System.out.println("Conexcion existosa");
		} catch (Exception e) {
			System.out.println("Error al conectar revise usuarioy contraseña");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(" error en el sistema: " + e.getMessage());
			}
		}
	}
}
