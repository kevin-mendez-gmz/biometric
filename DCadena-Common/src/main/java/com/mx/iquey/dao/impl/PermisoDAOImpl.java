package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.PermisoDAO;
import com.mx.iquey.to.PermisoTO;

@Repository
public class PermisoDAOImpl extends GenericDAOImpl<PermisoTO, Long> implements
		PermisoDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5574653035927740998L;

	public PermisoDAOImpl() {
		super(PermisoTO.class);
	}

	public void insert(PermisoTO permisoTO) {
		this.guardar(permisoTO);

	}

	public void update(PermisoTO permisoTO) {
		this.actualizar(permisoTO);
	}

	public void delete(PermisoTO permisoTO) {
		this.borrar(permisoTO);
	}

	public List<PermisoTO> getAll() {
		return buscar();
	}

	public List<PermisoTO> getPermisosByUser(int idUser) {
		StringBuilder query = new StringBuilder(
				"from PermisoTO where id_usuario = ").append(idUser)
				.append(" AND pantalla.sistema = '").append("Empacadora")
				.append("'");
		return executeQueryGetList(query.toString());
	}

	public List<PermisoTO> getAllPermisosByUser(int idUser) {
		StringBuilder query = new StringBuilder(
				"from PermisoTO where id_usuario = ").append(idUser);
		return executeQueryGetList(query.toString());
	}
}
