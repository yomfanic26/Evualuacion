package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakedevException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestActualizarCategoria {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cAct = new Categoria("0128", "XXXX");

		try {

			// Llamas al método actualizar con la nueva instancia
			ServiciosCategoria.actualizar(cAct);
			System.out.println("Ejucute actulizar");

		} catch (KrakedevException e) {
			System.out.println(" error en el sistema: " + e.getMessage());
		}

	}
}
