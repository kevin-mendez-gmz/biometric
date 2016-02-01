package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.ClienteTO;

public interface ClienteDAO {

	public void insert(ClienteTO clienteTO);

	public void update(ClienteTO clienteTO);

	public void delete(ClienteTO clienteTO);

	public List<ClienteTO> getAll();
	
	public List<ClienteTO> getClientesByZona(int idZona);

}
