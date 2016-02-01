package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.DevolucionDAO;
import com.mx.iquey.to.DevolucionTO;
import com.mx.iquey.to.PaseProduccionTO;

@Repository
public class DevolucionDAOImpl extends GenericDAOImpl<DevolucionTO, Long>
		implements DevolucionDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2820341072695863996L;

	public DevolucionDAOImpl() {
		super(DevolucionTO.class);
	}

	public void insert(DevolucionTO devolucionTO) {
		this.guardar(devolucionTO);

	}

	public void update(DevolucionTO devolucionTO) {
		this.actualizar(devolucionTO);
	}

	public void delete(DevolucionTO devolucionTO) {
		this.borrar(devolucionTO);
	}

	public List<DevolucionTO> getAll() {
		return buscar();
	}

	public List<DevolucionTO> getDevolucionByFecha(String fecha) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DevolucionTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);
	}

	public List<DevolucionTO> getDevolucionByFechaAndCliente(String fecha,
			int clienteId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DevolucionTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		criteria.add(Restrictions.eq("cliente.idCliente", clienteId));

		return this.getListByCriteria(criteria);
	}

	@Override
	public DevolucionTO getDevById(int idDev) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DevolucionTO.class);

		criteria.add(Restrictions.eq("idDev", idDev));

		return this.getTByCriteria(criteria);
	}
}
