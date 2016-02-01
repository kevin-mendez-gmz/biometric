package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.DevolucionTO;

public interface DevolucionDAO {

	public void insert(DevolucionTO devolucionTO);

	public void update(DevolucionTO devolucionTO);

	public void delete(DevolucionTO devolucionTO);

	public List<DevolucionTO> getAll();
	
	public List<DevolucionTO> getDevolucionByFecha(String fecha);
	
	public List<DevolucionTO> getDevolucionByFechaAndCliente(String fecha , int clienteId);
	
	public DevolucionTO getDevById(int idDev);

}
