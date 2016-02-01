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

@XmlRootElement
@Entity
@Table(name = "zona")
public class ZonaClienteTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6851503153734202407L;

	private int idZona;
	private String zona;

	public ZonaClienteTO() {
	}

	public ZonaClienteTO(ZonaClienteTO zona) {
		BeanUtils.copyProperties(zona, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_zona", unique = true, nullable = false)
	@XmlElement
	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	@Column(name = "zona")
	@XmlElement
	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}
