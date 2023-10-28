package com.krakedev.evaluacion.test;

import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestBuscarcategorias {

	public static void main(String[] args) {

		try {
			ArrayList<Categoria> categorias = ServiciosCategoria.buscarTodos();
			if (categorias.size() > 0) {
				System.out.println(categorias);

			} else {
				System.out.println("No se encontraron resultado de la busqueda");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
