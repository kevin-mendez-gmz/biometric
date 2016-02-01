package com.mx.iquey.to;

import java.util.List;

public class VentasAuxBean {

	private String cliente;
	private float total;
	private float totalVentas;
	private float totalDevoluciones;
	private List<VentaTO> listaVentas;
	private List<DevolucionTO> listaDevolucion;

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<VentaTO> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<VentaTO> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public List<DevolucionTO> getListaDevolucion() {
		return listaDevolucion;
	}

	public void setListaDevolucion(List<DevolucionTO> listaDevolucion) {
		this.listaDevolucion = listaDevolucion;
	}

	public float getTotalVentas() {
		return totalVentas;
	}

	public void setTotalVentas(float totalVentas) {
		this.totalVentas = totalVentas;
	}

	public float getTotalDevoluciones() {
		return totalDevoluciones;
	}

	public void setTotalDevoluciones(float totalDevoluciones) {
		this.totalDevoluciones = totalDevoluciones;
	}

}
