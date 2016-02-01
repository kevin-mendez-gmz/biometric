package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.HistorialCamaraTO;

public interface HistorialCamaraDAO {

	public void insert(HistorialCamaraTO historialCamaraTO);

	public void update(HistorialCamaraTO historialCamaraTO);

	public void delete(HistorialCamaraTO historialCamaraTO);

	public List<HistorialCamaraTO> getAll();

	public List<HistorialCamaraTO> getHistorialByCamara(int idCamara);

	public List<HistorialCamaraTO> getHistorialByProducto(int idTipoCarne);
	
	public HistorialCamaraTO getHistorialByProductoAndCamara(int idTipoCarne , int idCamara);
	
	public HistorialCamaraTO getHistorialById(int idHistorial);

}
