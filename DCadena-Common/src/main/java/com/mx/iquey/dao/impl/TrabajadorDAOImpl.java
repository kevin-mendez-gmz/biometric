package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.TrabajadorDAO;
import com.mx.iquey.to.TrabajadorTO;
import com.mx.iquey.to.VentaTO;

@Repository
public class TrabajadorDAOImpl extends GenericDAOImpl<TrabajadorTO, Long>
		implements TrabajadorDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403852094997050649L;

	public TrabajadorDAOImpl() {
		super(TrabajadorTO.class);
	}

	public void insert(TrabajadorTO TrabajadorTO) {
		guardar(TrabajadorTO);
	}

	public void update(TrabajadorTO TrabajadorTO) {
		actualizar(TrabajadorTO);
	}

	public void delete(TrabajadorTO TrabajadorTO) {
		borrar(TrabajadorTO);
	}

	public List<TrabajadorTO> getAll() {
		return buscar();
	}

	public TrabajadorTO getTrabajadorByHuella(byte[] huella) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TrabajadorTO.class);

		criteria.add(Restrictions.eq("huella", huella));

		return this.getTByCriteria(criteria);
	}

}
