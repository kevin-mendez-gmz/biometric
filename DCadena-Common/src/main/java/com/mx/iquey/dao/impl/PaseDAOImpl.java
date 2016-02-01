package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.PaseDAO;
import com.mx.iquey.to.CompraTO;
import com.mx.iquey.to.PaseProduccionTO;

@Repository
public class PaseDAOImpl extends GenericDAOImpl<PaseProduccionTO, Long>
		implements PaseDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5313753160699353035L;

	public PaseDAOImpl() {
		super(PaseProduccionTO.class);
	}

	public void insert(PaseProduccionTO paseProduccionTO) {
		this.guardar(paseProduccionTO);
	}

	public void update(PaseProduccionTO paseProduccionTO) {
		this.actualizar(paseProduccionTO);
	}

	public void delete(PaseProduccionTO paseProduccionTO) {
		this.borrar(paseProduccionTO);
	}

	public List<PaseProduccionTO> getPasesByFecha(String fecha) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(PaseProduccionTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);

	}

	@Override
	public PaseProduccionTO getPaseById(int idPaseProduccion) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(PaseProduccionTO.class);

		criteria.add(Restrictions.eq("idPaseProduccion", idPaseProduccion));

		return this.getTByCriteria(criteria);
	}

}
