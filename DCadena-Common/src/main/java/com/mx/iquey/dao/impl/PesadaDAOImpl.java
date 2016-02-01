package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.PesadaDAO;
import com.mx.iquey.to.PesadaTO;

@Repository
public class PesadaDAOImpl extends GenericDAOImpl<PesadaTO, Long> implements
		PesadaDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6463418901105845043L;

	public PesadaDAOImpl() {
		super(PesadaTO.class);
	}

	public void insert(PesadaTO pesadaTO) {
		guardar(pesadaTO);
	}

	public void update(PesadaTO pesadaTO) {
		actualizar(pesadaTO);
	}

	public void delete(PesadaTO pesadaTO) {
		borrar(pesadaTO);
	}

	public List<PesadaTO> getAll() {
		return buscar();
	}

	public List<PesadaTO> getPesadaByFecha(String fecha) {

		StringBuilder builder = new StringBuilder(
				"from PesadaTO where fecha = '").append(fecha).append("'");

		return this.executeQueryGetList(builder.toString());
	}

	@Override
	public PesadaTO getPesadaById(int idPesada) {

		DetachedCriteria criteria = DetachedCriteria.forClass(PesadaTO.class);

		criteria.add(Restrictions.eq("idPesada", idPesada));

		return this.getTByCriteria(criteria);

	}

}
