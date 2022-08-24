package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class Vehiculo {
	private String modelo;
	private String marca;
	private BigDecimal precio;
	
	public Vehiculo() {
	};

	public Vehiculo(String modelo, String marca, BigDecimal precio) {
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + "]";
	}

	
}