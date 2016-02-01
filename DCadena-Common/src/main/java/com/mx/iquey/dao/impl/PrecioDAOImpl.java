package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.PrecioDAO;
import com.mx.iquey.to.PrecioTO;

@Repository
public class PrecioDAOImpl extends GenericDAOImpl<PrecioTO, Long> implements
		PrecioDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2123219319606581428L;

	public PrecioDAOImpl() {
		super(PrecioTO.class);
	}

	public void insert(PrecioTO precioTO) {
		this.guardar(precioTO);

	}

	public void update(PrecioTO precioTO) {
		this.actualizar(precioTO);
	}

	public void delete(PrecioTO precioTO) {
		this.borrar(precioTO);
	}

	public List<PrecioTO> getAll() {
		return buscar();
	}

	public List<PrecioTO> getPreciosByCliente(int idCliente) {

		StringBuilder query = new StringBuilder(
				"from PrecioTO where id_cliente = ").append(idCliente);

		return executeQueryGetList(query.toString());
	}

	@Override
	public PrecioTO getPrecioByClienteAndProducto(int idCliente, int idProducto) {

		DetachedCriteria criteria = DetachedCriteria.forClass(PrecioTO.class);

		criteria.add(Restrictions.eq("cliente.idCliente", idCliente));

		criteria.add(Restrictions.eq("tipoCarne.idTipoCarne", idProducto));

		return getTByCriteria(criteria);

	}

}
