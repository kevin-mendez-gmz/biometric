package com.mx.iquey.to;

import java.io.Serializable;

public class ResumenVentasTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3252623314916401932L;
	private String fecha;
	private int numPiezas;
	private float pesoTotal;
	private float ventaTotal;
	private float promedioPrecio;
	private int numVentas;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumPiezas() {
		return numPiezas;
	}

	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
	}

	public float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public float getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(float ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public float getPromedioPrecio() {
		return promedioPrecio;
	}

	public void setPromedioPrecio(float promedioPrecio) {
		this.promedioPrecio = promedioPrecio;
	}

	public int getNumVentas() {
		return numVentas;
	}

	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}

}
