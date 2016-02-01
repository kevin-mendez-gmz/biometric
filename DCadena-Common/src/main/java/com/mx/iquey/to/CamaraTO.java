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
@Table(name = "camaras")
public class CamaraTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6851503153734202407L;

	private int idCamara;
	private String nombre;

	public CamaraTO() {
	}

	public CamaraTO(CamaraTO camara) {
		BeanUtils.copyProperties(camara, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_camara", unique = true, nullable = false)
	@XmlElement
	public int getIdCamara() {
		return idCamara;
	}

	public void setIdCamara(int idCamara) {
		this.idCamara = idCamara;
	}

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
