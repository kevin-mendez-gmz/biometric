package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.TipoCarneTO;

public interface TipoCarneDAO {

	public void insert(TipoCarneTO tipoCarneTO);

	public void update(TipoCarneTO tipoCarneTO);

	public void delete(TipoCarneTO tipoCarneTO);

	public List<TipoCarneTO> getAll();

	public List<TipoCarneTO> getTipoCarneDevoluciones();

	public List<TipoCarneTO> getTipoCarneVentas();
	
	public List<TipoCarneTO> getTipoCarneProveedores();

}
