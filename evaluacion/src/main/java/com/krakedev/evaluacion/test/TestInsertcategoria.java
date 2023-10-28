package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestInsertcategoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Categoria c = new Categoria("0127", "Prueba");
		try {
			ServiciosCategoria.insertar(c);


			System.out.println("Ejucute insert");

		} catch (Exception e) {
			System.out.println(" error en el sistema: " + e.getMessage());
		}

	}

}
