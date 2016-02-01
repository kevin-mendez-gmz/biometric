package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.PaseProduccionTO;

public interface PaseDAO {

	public void insert(PaseProduccionTO paseProduccionTO);

	public void update(PaseProduccionTO paseProduccionTO);

	public void delete(PaseProduccionTO paseProduccionTO);

	public List<PaseProduccionTO> getPasesByFecha(String fecha);
	
	public PaseProduccionTO getPaseById(int idPaseProduccion);

}
