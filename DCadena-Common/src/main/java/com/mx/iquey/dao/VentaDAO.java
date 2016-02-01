package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.VentaTO;

public interface VentaDAO {

	public void insert(VentaTO ventaTO);

	public void update(VentaTO ventaTO);

	public void delete(VentaTO ventaTO);

	public List<VentaTO> getAll();

	public List<VentaTO> getVentaByCliente(int idCliente);

	public List<VentaTO> getVentaByClienteByFecha(int idCliente, String fecha);

	public List<VentaTO> getVentaByFecha(String fecha);

	public List<VentaTO> getVentaByFechaAndTipoCarne(String fecha,
			int idTipoCarne);

	public List<VentaTO> getVentaByZona(String fecha, int idZona);

	public List<VentaTO> getVentaByTipoCarne(int idTipoCarne);

	public List<Integer> getDistinct(String fecha);

	public VentaTO getVenta(int idCliente, int idTipoCarne, String fecha);

	public VentaTO getVentaById(int idVenta);

	public VentaTO getVentaParaDevolucion(int idCliente, String fecha,
			int idTipoCarne);

}
