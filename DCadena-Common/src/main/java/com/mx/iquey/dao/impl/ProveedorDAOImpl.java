package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.ProveedorDAO;
import com.mx.iquey.to.ProveedorTO;

@Repository
public class ProveedorDAOImpl extends GenericDAOImpl<ProveedorTO, Long>
		implements ProveedorDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4135527460680664042L;

	public ProveedorDAOImpl() {
		super(ProveedorTO.class);
	}

	public void insert(ProveedorTO proveedorTO) {
		guardar(proveedorTO);
	}

	public void update(ProveedorTO proveedorTO) {
		actualizar(proveedorTO);
	}

	public void delete(ProveedorTO proveedorTO) {
		borrar(proveedorTO);
	}

	public List<ProveedorTO> getAll() {
		return buscar();
	}

}
