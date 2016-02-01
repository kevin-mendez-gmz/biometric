package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.VentaDAO;
import com.mx.iquey.to.VentaTO;

@Repository
public class VentaDAOImpl extends GenericDAOImpl<VentaTO, Long> implements
		VentaDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8061572522657166187L;

	public VentaDAOImpl() {
		super(VentaTO.class);
	}

	public void insert(VentaTO ventaTO) {
		guardar(ventaTO);
	}

	public void update(VentaTO ventaTO) {
		actualizar(ventaTO);
	}

	public void delete(VentaTO ventaTO) {
		borrar(ventaTO);
	}

	public List<VentaTO> getAll() {
		return buscar();
	}

	public List<VentaTO> getVentaByCliente(int idCliente) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idCliente.idCliente", idCliente));

		return this.getListByCriteria(criteria);

	}

	public List<VentaTO> getVentaByClienteByFecha(int idCliente, String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idCliente.idCliente", idCliente));
		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);
	}

	public List<VentaTO> getVentaByFecha(String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);
	}

	public List<VentaTO> getVentaByFechaAndTipoCarne(String fecha,
			int idTipoCarne) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));
		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);

	}

	public List<VentaTO> getVentaByTipoCarne(int idTipoCarne) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));

		return this.getListByCriteria(criteria);
	}

	public List<Integer> getDistinct(String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		criteria.setProjection(Projections.distinct(Projections
				.property("idCliente.idCliente")));

		return this.getIntegerByCriteria(criteria);
	}

	public VentaTO getVenta(int idCliente, int idTipoCarne, String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idCliente.idCliente", idCliente));
		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));
		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getTByCriteria(criteria);
	}

	@Override
	public List<VentaTO> getVentaByZona(String fecha, int idZona) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idCliente.idCliente", idZona));
		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);
	}

	@Override
	public VentaTO getVentaById(int idVenta) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idVenta", idVenta));

		return this.getTByCriteria(criteria);
	}

	@Override
	public VentaTO getVentaParaDevolucion(int idCliente, String fecha,
			int idTipoCarne) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VentaTO.class);

		criteria.add(Restrictions.eq("idCliente.idCliente", idCliente));
		criteria.add(Restrictions.eq("fecha", fecha));
		criteria.add(Restrictions.eq("idTipoCarne.idTipoCarne", idTipoCarne));

		return this.getTByCriteria(criteria);
	}

}
