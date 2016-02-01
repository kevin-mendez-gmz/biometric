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
@Table(name = "clasificacion_puestos")
@XmlRootElement
public class ClasificacionPuestoTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -6403579579160117790L;

	private int idClasificacion;
	private String clasificacion;

	public ClasificacionPuestoTO() {
	}

	public ClasificacionPuestoTO(ClasificacionPuestoTO clasificacion) {
		BeanUtils.copyProperties(clasificacion, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_clasificacion", unique = true, nullable = false)
	@XmlElement
	public int getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(int idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	@Column(name = "clasificacion")
	@XmlElement
	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

}