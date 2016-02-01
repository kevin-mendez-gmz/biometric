package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.ProveedorTO;

public interface ProveedorDAO {

	public void insert(ProveedorTO proveedorTO);

	public void update(ProveedorTO proveedorTO);

	public void delete(ProveedorTO proveedorTO);

	public List<ProveedorTO> getAll();

}
