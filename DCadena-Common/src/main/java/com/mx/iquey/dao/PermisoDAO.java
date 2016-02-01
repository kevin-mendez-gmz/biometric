package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.PermisoTO;

public interface PermisoDAO {

	public void insert(PermisoTO permisoTO);

	public void update(PermisoTO permisoTO);

	public void delete(PermisoTO permisoTO);

	public List<PermisoTO> getAll();
	
	public List<PermisoTO> getPermisosByUser(int idUser);
	
	public List<PermisoTO> getAllPermisosByUser(int idUser);

}
