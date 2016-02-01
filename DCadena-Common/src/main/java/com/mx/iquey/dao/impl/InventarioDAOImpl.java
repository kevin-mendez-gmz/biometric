package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.InventarioDAO;
import com.mx.iquey.to.InventarioTO;

@Repository
public class InventarioDAOImpl extends GenericDAOImpl<InventarioTO, Long>
		implements InventarioDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8724725879008170393L;

	public InventarioDAOImpl() {
		super(InventarioTO.class);
	}

	public void insert(InventarioTO inventarioTO) {
		this.guardar(inventarioTO);
	}

	public void update(InventarioTO inventarioTO) {
		this.actualizar(inventarioTO);
	}

	public void delete(InventarioTO inventarioTO) {
		this.borrar(inventarioTO);
	}

	public List<InventarioTO> getAll() {
		return this.buscar();
	}

	public List<InventarioTO> getInventarioByPieza(int idTipoPieza) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(InventarioTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoPieza));

		return this.getListByCriteria(criteria);
	}

	@Override
	public InventarioTO getInventarioByPiezaAndLote(int idTipoPieza, int lote) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(InventarioTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoPieza));
		criteria.add(Restrictions.eq("lote", lote));

		return this.getTByCriteria(criteria);
	}

	public void deleteInventarioIsNotDate(InventarioTO inventarioTO) {

		Query query = getSession().createQuery(QUERY_DELETE_INVENTARIO);

		query.setParameter("fecha", inventarioTO.getFecha());

		int result = query.executeUpdate();

	}

	@Override
	public InventarioTO getInventarioByPiezaAndComentario(int idTipoPieza,
			String comentario) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(InventarioTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoPieza));
		criteria.add(Restrictions.eq("comentario", comentario));

		return this.getTByCriteria(criteria);
	}
}
