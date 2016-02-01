package com.mx.iquey.to;

import java.io.Serializable;
import java.util.List;

public class CompraAuxTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3950717423978700376L;

	private String proveedor;
	private float total;
	private List<CompraTO> listaCompras;

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<CompraTO> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<CompraTO> listaCompras) {
		this.listaCompras = listaCompras;
	}

}
