package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.HistorialCamaraDAO;
import com.mx.iquey.to.HistorialCamaraTO;

@Repository
public class HistorialCamaraDAOImpl extends
		GenericDAOImpl<HistorialCamaraTO, Long> implements HistorialCamaraDAO,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1041976058982680823L;

	public HistorialCamaraDAOImpl() {
		super(HistorialCamaraTO.class);
	}

	public void insert(HistorialCamaraTO camaraTO) {
		this.guardar(camaraTO);

	}

	public void update(HistorialCamaraTO camaraTO) {
		this.actualizar(camaraTO);
	}

	public void delete(HistorialCamaraTO camaraTO) {
		this.borrar(camaraTO);
	}

	public List<HistorialCamaraTO> getAll() {
		return buscar();
	}

	@Override
	public List<HistorialCamaraTO> getHistorialByCamara(int idCamara) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(HistorialCamaraTO.class);

		criteria.add(Restrictions.eq("camaraTO.idCamara", idCamara));

		return this.getListByCriteria(criteria);
	}

	@Override
	public List<HistorialCamaraTO> getHistorialByProducto(int idTipoCarne) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(HistorialCamaraTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));

		return this.getListByCriteria(criteria);
	}

	@Override
	public HistorialCamaraTO getHistorialByProductoAndCamara(int idTipoCarne,
			int idCamara) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(HistorialCamaraTO.class);

		criteria.add(Restrictions.eq("camaraTO.idCamara", idCamara));

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));

		return this.getTByCriteria(criteria);
	}

	@Override
	public HistorialCamaraTO getHistorialById(int idHistorial) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(HistorialCamaraTO.class);

		criteria.add(Restrictions.eq("idHistorial", idHistorial));

		return this.getTByCriteria(criteria);
	}

}
