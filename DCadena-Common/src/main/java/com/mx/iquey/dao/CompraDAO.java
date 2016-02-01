package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.CompraTO;

public interface CompraDAO {

	public void insert(CompraTO compraTO);

	public void update(CompraTO compraTO);

	public void delete(CompraTO compraTO);

	public List<CompraTO> getAll();

	public List<CompraTO> getCompraByProveedor(int idProveedor);

	public List<CompraTO> getCompraByProveedorByFecha(int idProveedor,
			String fecha);

	public List<CompraTO> getCompraByFecha(String fecha);

	public List<CompraTO> getCompraByFechaAndTipoCarne(String fecha,
			int idTipoCarne);
	
	public CompraTO getCompraById(int idCompra);

}
