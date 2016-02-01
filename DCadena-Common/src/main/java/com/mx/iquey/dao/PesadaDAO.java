package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.PesadaTO;

public interface PesadaDAO {

	public void insert(PesadaTO pesadaTO);

	public void update(PesadaTO pesadaTO);

	public void delete(PesadaTO pesadaTO);

	public List<PesadaTO> getAll();

	public List<PesadaTO> getPesadaByFecha(String fecha);
	
	public PesadaTO getPesadaById(int idPesada);

}
