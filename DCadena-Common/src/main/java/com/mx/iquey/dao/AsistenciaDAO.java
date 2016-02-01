package com.mx.iquey.dao;

import java.util.Date;
import java.util.List;

import com.mx.iquey.to.AsistenciaTO;

public interface AsistenciaDAO {

	public void insert(AsistenciaTO asistenciaTO);

	public void update(AsistenciaTO asistenciaTO);

	public void delete(AsistenciaTO asistenciaTO);

	public List<AsistenciaTO> getAll();

	public AsistenciaTO getAsistenciaByFechaAndTrabajador(String fecha,
			int idTrabajador);
	
	public AsistenciaTO getAsistenciaByTrabajador(
			int idTrabajador);
	
	public List<AsistenciaTO> getAsistenciasBetweenDates(Date fechaInicio , Date fechaFinal , int idTrabajador);

}
