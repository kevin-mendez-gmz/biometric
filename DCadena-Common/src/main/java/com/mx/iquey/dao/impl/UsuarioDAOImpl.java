package com.mx.iquey.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mx.iquey.dao.UsuarioDAO;
import com.mx.iquey.to.UsuarioTO;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<UsuarioTO, Long> implements
		UsuarioDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4181604434838771798L;

	public UsuarioDAOImpl() {
		super(UsuarioTO.class);
	}

	public void insert(UsuarioTO usuarioTO) {
		this.guardar(usuarioTO);

	}

	public void update(UsuarioTO usuarioTO) {
		this.actualizar(usuarioTO);
	}

	public void delete(UsuarioTO usuarioTO) {
		this.borrar(usuarioTO);
	}

	public UsuarioTO getUserbyPass(String pass) {
		StringBuilder builder = new StringBuilder(
				"from UsuarioTO where password = '").append(pass).append("'");
		return this.executeQuery(builder.toString());
	}

	public List<UsuarioTO> getAll() {
		return buscar();
	}

	public UsuarioTO getUser(String user, String pass) {
		StringBuilder builder = new StringBuilder(
				"from UsuarioTO where password = '").append(pass)
				.append("' AND usuario = '").append(user).append("'");
		return this.executeQuery(builder.toString());
	}

}
