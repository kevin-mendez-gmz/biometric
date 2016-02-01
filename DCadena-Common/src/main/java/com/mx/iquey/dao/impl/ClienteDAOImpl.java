package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.ClienteDAO;
import com.mx.iquey.to.ClienteTO;

@Repository
public class ClienteDAOImpl extends GenericDAOImpl<ClienteTO, Long> implements
		ClienteDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1041976058982680823L;

	public ClienteDAOImpl() {
		super(ClienteTO.class);
	}

	public void insert(ClienteTO clienteTO) {
		this.guardar(clienteTO);

	}

	public void update(ClienteTO clienteTO) {
		this.actualizar(clienteTO);
	}

	public void delete(ClienteTO clienteTO) {
		this.borrar(clienteTO);
	}

	public List<ClienteTO> getAll() {
		return buscar();
	}

	public List<ClienteTO> getClientesByZona(int idZona) {

		DetachedCriteria criteria = DetachedCriteria.forClass(ClienteTO.class);

		criteria.add(Restrictions.eq("idZona.idZona", idZona));

		criteria.addOrder(Order.asc("nombre"));

		return this.getListByCriteria(criteria);
	}

}
