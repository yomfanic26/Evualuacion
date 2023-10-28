package com.krakedev.evaluacion.entidades;

import java.math.BigDecimal;

public class Producto {

	private String id;
	private String nombre;
	private BigDecimal precio_venta;
	private BigDecimal precio_compra;
	private Categoria categoria;

	public Producto() {
		super();
	}

	public Producto(String id, String nombre, BigDecimal precio_venta, BigDecimal precio_compra, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio_venta = precio_venta;
		this.precio_compra = precio_compra;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio_venta=" + precio_venta + ", precio_compra="
				+ precio_compra + ", categoria=" + categoria + "]";
	}

}
