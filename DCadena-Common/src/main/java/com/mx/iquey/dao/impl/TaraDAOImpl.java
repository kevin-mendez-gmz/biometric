package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.TaraDAO;
import com.mx.iquey.to.TaraTO;

@Repository
public class TaraDAOImpl extends GenericDAOImpl<TaraTO, Long> implements
		TaraDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9189290642581507851L;

	public TaraDAOImpl() {
		super(TaraTO.class);
	}

	public void insert(TaraTO taraTO) {
		this.guardar(taraTO);

	}

	public void update(TaraTO taraTO) {
		this.actualizar(taraTO);
	}

	public void delete(TaraTO taraTO) {
		this.borrar(taraTO);
	}

	public List<TaraTO> getAll() {
		return buscar();
	}

}
