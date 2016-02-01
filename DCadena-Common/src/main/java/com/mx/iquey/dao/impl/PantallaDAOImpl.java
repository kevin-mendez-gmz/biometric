package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.PantallaDAO;
import com.mx.iquey.to.PantallaTO;

@Repository
public class PantallaDAOImpl extends GenericDAOImpl<PantallaTO, Long> implements
		PantallaDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4173789317747548961L;

	public PantallaDAOImpl() {
		super(PantallaTO.class);
	}

	public List<PantallaTO> getAll() {
		return buscar();
	}

}
