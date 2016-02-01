package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.PrecioTO;

public interface PrecioDAO {

	public void insert(PrecioTO precioTO);

	public void update(PrecioTO precioTO);

	public void delete(PrecioTO precioTO);

	public List<PrecioTO> getAll();

	public List<PrecioTO> getPreciosByCliente(int idCliente);
	
	public PrecioTO getPrecioByClienteAndProducto(int idCliente , int idProducto);
	
}
