package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.ZonaClienteDAO;
import com.mx.iquey.to.ZonaClienteTO;

@Repository
public class ZonaClienteDAOImpl extends GenericDAOImpl<ZonaClienteTO, Long>
		implements ZonaClienteDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4135527460680664042L;

	public ZonaClienteDAOImpl() {
		super(ZonaClienteTO.class);
	}

	public void insert(ZonaClienteTO zonaClienteTO) {
		guardar(zonaClienteTO);
	}

	public void update(ZonaClienteTO zonaClienteTO) {
		actualizar(zonaClienteTO);
	}

	public void delete(ZonaClienteTO zonaClienteTO) {
		borrar(zonaClienteTO);
	}

	public List<ZonaClienteTO> getAll() {
		return buscar();
	}

}
