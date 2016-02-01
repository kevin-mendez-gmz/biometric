package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.CompraDAO;
import com.mx.iquey.to.CompraTO;
import com.mx.iquey.to.VentaTO;

@Repository
public class CompraDAOImpl extends GenericDAOImpl<CompraTO, Long> implements
		CompraDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5654290513523204193L;

	public CompraDAOImpl() {
		super(CompraTO.class);
	}

	public void insert(CompraTO compraTO) {
		guardar(compraTO);
	}

	public void update(CompraTO compraTO) {
		actualizar(compraTO);
	}

	public void delete(CompraTO compraTO) {
		borrar(compraTO);
	}

	public List<CompraTO> getAll() {
		return buscar();
	}

	public List<CompraTO> getCompraByProveedor(int idProveedor) {
		StringBuilder builder = new StringBuilder(
				"from CompraTO where idProveedor = ").append(idProveedor);
		return this.executeQueryGetList(builder.toString());

	}

	public List<CompraTO> getCompraByProveedorByFecha(int idProveedor,
			String fecha) {

		StringBuilder builder = new StringBuilder(
				"from CompraTO where idProveedor = ").append(idProveedor)
				.append(" AND fecha = '").append(fecha).append("'");

		return this.executeQueryGetList(builder.toString());
	}

	public List<CompraTO> getCompraByFecha(String fecha) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CompraTO.class);

		criteria.add(Restrictions.eq("fecha", fecha));

		return this.getListByCriteria(criteria);

	}

	public List<CompraTO> getCompraByFechaAndTipoCarne(String fecha,
			int idTipoCarne) {

		StringBuilder builder = new StringBuilder(
				"from CompraTO where idTipoCarne = ").append(idTipoCarne)
				.append(" AND fecha = '").append(fecha).append("'");

		return this.executeQueryGetList(builder.toString());

	}

	@Override
	public CompraTO getCompraById(int idCompra) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CompraTO.class);

		criteria.add(Restrictions.eq("idCompra", idCompra));

		return this.getTByCriteria(criteria);
	}
}
