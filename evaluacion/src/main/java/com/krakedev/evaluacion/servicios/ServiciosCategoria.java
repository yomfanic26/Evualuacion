package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakedevException;
import com.krakedev.evaluacion.utils.ConexcionBDD;

public class ServiciosCategoria {

	private static final Logger LOGGER = LogManager.getFormatterLogger(ServiciosCategoria.class);

	public static void insertar(Categoria categoria) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Cuenta a insertar >>>> " + categoria);

		try {
			// abriendo conexcionS
			con = ConexcionBDD.conectar();
			ps = con.prepareStatement("INSERT INTO categorias(id, nombre)" + "VALUES (?,?)");
			ps.setString(1, categoria.getId());
			ps.setString(2, categoria.getNombre());

			ps.executeUpdate();

		} catch (KrakedevException e) {

			LOGGER.error("Error al insertar", e);

			throw e;

		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error enla base de datos", e);
				throw new KrakedevException("Error en la base de datos");
			}

		}

	}

	public static void actualizar(Categoria categoria) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		LOGGER.trace("Categoria a actualizar >>>> " + categoria);

		try {
			// abriendo conexcionS
			con = ConexcionBDD.conectar();
			ps = con.prepareStatement("update categorias  set  nombre=? where id=?");

			ps.setString(2, categoria.getId());
			ps.setString(1, categoria.getNombre());

			int resultado = ps.executeUpdate();
			if (resultado==0) {
				throw new KrakedevException ("No existe la categoria con la llave asiganada");
			}

		} catch (KrakedevException e) {

			LOGGER.error("Error al actualizar", e);
			throw e;

		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error enla base de datos", e);
				// en SQLEXEPTIOn debeo instancia el objeto por que tienen un erro tecnico
				throw new KrakedevException("Error en la base de datos");
			}

		}

	}
	
	public static Categoria buscarPorPk(String id) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categoria categoria = null;

		try {
			con = ConexcionBDD.conectar();
			ps = con.prepareStatement("select * from categorias where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				String nombre = rs.getString("nombre");
			

				categoria = new Categoria();

				categoria.setId(id);
				categoria.setNombre(nombre);
				

			} else {
				LOGGER.error("No se encontró ninguna persona con cédula: " + id);

			}
			return categoria;

		} catch (Exception e) {
			LOGGER.error("Error al consultar por id", e);
			throw new Exception("Error al consultar por id");
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error enla base de datos", e);
				throw new Exception("Error en la base de datos");
			}
		}

	}
	
	public static ArrayList<Categoria> buscarTodos() throws Exception {
		ArrayList<Categoria> categorias = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConexcionBDD.conectar();
			ps = con.prepareStatement("select * from categorias ");
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
		

				Categoria categoria = new Categoria();
				categoria.setId(id);
				categoria.setNombre(nombre);
				categorias.add(categoria);

			}

		} catch (Exception e) {
			LOGGER.error("Error al consultar ", e);
			throw new Exception("Error al consultar ");
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error enla base de datos", e);
				throw new Exception("Error en la base de datos");
			}
		}
		return categorias;
	}

}
