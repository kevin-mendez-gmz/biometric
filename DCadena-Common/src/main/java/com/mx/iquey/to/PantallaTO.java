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
@Table(name = "pantallas")
@XmlRootElement
public class PantallaTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8488962017528412611L;
	private int idPantalla;
	private String pantalla;
	private String funcionalidad;
	private String sistema;

	public PantallaTO() {
	}

	public PantallaTO(PantallaTO pantalla) {
		BeanUtils.copyProperties(pantalla, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_pantalla", unique = true, nullable = false)
	@XmlElement
	public int getIdPantalla() {
		return idPantalla;
	}

	public void setIdPantalla(int idPantalla) {
		this.idPantalla = idPantalla;
	}

	@Column(name = "pantalla", length = 45)
	@XmlElement
	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	@Column(name = "funcionalidad", length = 200)
	@XmlElement
	public String getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	@Column(name = "sistema", length = 45)
	@XmlElement
	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

}
