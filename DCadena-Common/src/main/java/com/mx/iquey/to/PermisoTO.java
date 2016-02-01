package com.mx.iquey.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "permisos")
@XmlRootElement
public class PermisoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8686978524692587633L;
	private int idPermiso;
	private UsuarioTO usuario;
	private PantallaTO pantalla;
	private boolean ver;

	public PermisoTO() {

	}

	public PermisoTO(PermisoTO permiso) {
		BeanUtils.copyProperties(permiso, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_permiso", unique = true, nullable = false)
	@XmlElement
	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	@XmlElement
	public UsuarioTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pantalla")
	@XmlElement
	public PantallaTO getPantalla() {
		return pantalla;
	}

	public void setPantalla(PantallaTO pantalla) {
		this.pantalla = pantalla;
	}

	@Column(name = "ver")
	@XmlElement
	public boolean getVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

}
