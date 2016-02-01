package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.CajasDAO;
import com.mx.iquey.to.CajasTO;

@Repository
public class CajasDAOImpl extends GenericDAOImpl<CajasTO, Long> implements
		CajasDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403852094997050649L;

	public CajasDAOImpl() {
		super(CajasTO.class);
	}

	public void insert(CajasTO cajasTO) {
		this.guardar(cajasTO);
	}

	public void update(CajasTO cajasTO) {
		this.actualizar(cajasTO);
	}

	public void delete(CajasTO cajasTO) {
		this.borrar(cajasTO);
	}

	public List<CajasTO> getAll() {
		return this.buscar();
	}

	public List<CajasTO> getCajasByFecha(String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CajasTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);
	}
}
