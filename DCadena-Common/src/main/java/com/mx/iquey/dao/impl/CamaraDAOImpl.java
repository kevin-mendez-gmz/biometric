package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.CamaraDAO;
import com.mx.iquey.to.CamaraTO;

@Repository
public class CamaraDAOImpl extends GenericDAOImpl<CamaraTO, Long> implements
		CamaraDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1041976058982680823L;

	public CamaraDAOImpl() {
		super(CamaraTO.class);
	}

	public void insert(CamaraTO camaraTO) {
		this.guardar(camaraTO);

	}

	public void update(CamaraTO camaraTO) {
		this.actualizar(camaraTO);
	}

	public void delete(CamaraTO camaraTO) {
		this.borrar(camaraTO);
	}

	public List<CamaraTO> getAll() {
		return buscar();
	}

}
