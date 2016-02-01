package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.TipoCarneDAO;
import com.mx.iquey.to.TipoCarneTO;

@Repository
public class TipoCarneDAOImpl extends GenericDAOImpl<TipoCarneTO, Long>
		implements TipoCarneDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403852094997050649L;

	public TipoCarneDAOImpl() {
		super(TipoCarneTO.class);
	}

	public void insert(TipoCarneTO tipoCarneTO) {
		guardar(tipoCarneTO);
	}

	public void update(TipoCarneTO tipoCarneTO) {
		actualizar(tipoCarneTO);
	}

	public void delete(TipoCarneTO tipoCarneTO) {
		borrar(tipoCarneTO);
	}

	public List<TipoCarneTO> getAll() {
		return buscar();
	}

	public List<TipoCarneTO> getTipoCarneDevoluciones() {

		StringBuilder builder = new StringBuilder(
				"from TipoCarneTO where devoluciones = 1");

		return this.executeQueryGetList(builder.toString());
	}

	public List<TipoCarneTO> getTipoCarneVentas() {

		StringBuilder builder = new StringBuilder(
				"from TipoCarneTO where ventas = 1");

		return this.executeQueryGetList(builder.toString());
	}

	public List<TipoCarneTO> getTipoCarneProveedores() {
		StringBuilder builder = new StringBuilder(
				"from TipoCarneTO where proveedores = 1");

		return this.executeQueryGetList(builder.toString());
	}

}
