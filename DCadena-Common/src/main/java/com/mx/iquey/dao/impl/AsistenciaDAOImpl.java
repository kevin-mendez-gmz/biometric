package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.AsistenciaDAO;
import com.mx.iquey.to.AsistenciaTO;
import com.mx.utils.Constantes;

@Repository
public class AsistenciaDAOImpl extends GenericDAOImpl<AsistenciaTO, Long>
		implements AsistenciaDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403852094997050649L;

	public AsistenciaDAOImpl() {
		super(AsistenciaTO.class);
	}

	public void insert(AsistenciaTO AsistenciaTO) {
		guardar(AsistenciaTO);
	}

	public void update(AsistenciaTO AsistenciaTO) {
		actualizar(AsistenciaTO);
	}

	public void delete(AsistenciaTO AsistenciaTO) {
		borrar(AsistenciaTO);
	}

	public List<AsistenciaTO> getAll() {
		return buscar();
	}

	public AsistenciaTO getAsistenciaByFechaAndTrabajador(String fecha,
			int idTrabajador) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(AsistenciaTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));
		criteria.add(Restrictions.eq("trabajador.idTrabajador", idTrabajador));

		return this.getTByCriteria(criteria);
	}

	public List<AsistenciaTO> getAsistenciasBetweenDates(Date fechaInicio,
			Date fechaFinal, int idTrabajador) {

		DateFormat dataFormat = new SimpleDateFormat(Constantes.FORMATO_FECHA);

		String fechaInicioStr = dataFormat.format(fechaInicio);
		String fechaFinalStr = dataFormat.format(fechaFinal);

		DetachedCriteria criteria = DetachedCriteria
				.forClass(AsistenciaTO.class);

		criteria.add(Restrictions.between("fecha", fechaInicioStr,
				fechaFinalStr));
		criteria.add(Restrictions.eq("trabajador.idTrabajador", idTrabajador));

		return this.getListByCriteria(criteria);
	}

	@Override
	public AsistenciaTO getAsistenciaByTrabajador(int idTrabajador) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(AsistenciaTO.class);

		criteria.add(Restrictions.eq("trabajador.idTrabajador", idTrabajador));

		criteria.add(Restrictions.isNull("horaSalida"));

		return this.getTByCriteria(criteria);

	}
}
