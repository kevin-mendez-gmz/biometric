package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.ZonaClienteTO;

public interface ZonaClienteDAO {

	public void insert(ZonaClienteTO zonaClienteTO);

	public void update(ZonaClienteTO zonaClienteTO);

	public void delete(ZonaClienteTO zonaClienteTO);

	public List<ZonaClienteTO> getAll();

}
