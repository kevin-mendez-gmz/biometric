package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.CamaraTO;

public interface CamaraDAO {

	public void insert(CamaraTO camaraTO);

	public void update(CamaraTO camaraTO);

	public void delete(CamaraTO camaraTO);

	public List<CamaraTO> getAll();

}
