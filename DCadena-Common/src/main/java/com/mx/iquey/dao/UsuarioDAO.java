package com.mx.iquey.dao;

import java.util.List;

import com.mx.iquey.to.UsuarioTO;

public interface UsuarioDAO {

	public void insert(UsuarioTO usuarioTO);

	public void update(UsuarioTO usuarioTO);

	public void delete(UsuarioTO usuarioTO);

	public List<UsuarioTO> getAll();

	public UsuarioTO getUserbyPass(String pass);

	public UsuarioTO getUser(String user, String pass);

}
