package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.CajasTO;

public interface CajasDAO {

	public void insert(CajasTO cajasTO);

	public void update(CajasTO cajasTO);

	public void delete(CajasTO cajasTO);

	public List<CajasTO> getAll();

	public List<CajasTO> getCajasByFecha(String fecha);

}
