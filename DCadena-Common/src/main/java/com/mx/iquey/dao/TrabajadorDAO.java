package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.TrabajadorTO;

public interface TrabajadorDAO {

	public void insert(TrabajadorTO trabajadorTO);

	public void update(TrabajadorTO trabajadorTO);

	public void delete(TrabajadorTO trabajadorTO);

	public List<TrabajadorTO> getAll();

	public TrabajadorTO getTrabajadorByHuella(byte[] huella);

}
