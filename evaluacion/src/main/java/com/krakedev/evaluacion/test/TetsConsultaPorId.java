package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TetsConsultaPorId {

	public static void main(String[] args) {
		try {
			Categoria c = ServiciosCategoria.buscarPorPk("C005");

			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
