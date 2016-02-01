package com.mx.iquey.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "usuarios")
@XmlRootElement
public class UsuarioTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1864216532935175033L;

	public UsuarioTO() {

	}

	public UsuarioTO(UsuarioTO usuario) {
		BeanUtils.copyProperties(usuario, this);

	}

	private int idUsuario;
	private String usuario;
	private String password;

	@Id
	@GeneratedValue
	@Column(name = "id_usuario", unique = true, nullable = false)
	@XmlElement
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "usuario", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UsuarioTO [idUsuario=" + idUsuario + ", usuario=" + usuario
				+ ", password=" + password + "]";
	}

}
