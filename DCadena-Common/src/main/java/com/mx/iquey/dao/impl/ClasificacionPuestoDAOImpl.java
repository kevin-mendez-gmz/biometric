package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.ClasificacionPuestoDAO;
import com.mx.iquey.to.ClasificacionPuestoTO;

@Repository
public class ClasificacionPuestoDAOImpl extends
		GenericDAOImpl<ClasificacionPuestoTO, Long> implements
		ClasificacionPuestoDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403852094997050649L;

	public ClasificacionPuestoDAOImpl() {
		super(ClasificacionPuestoTO.class);
	}

	public List<ClasificacionPuestoTO> getAll() {
		return buscar();
	}

}
