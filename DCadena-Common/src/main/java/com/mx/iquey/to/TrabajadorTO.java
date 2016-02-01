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

@XmlRootElement
@Entity
@Table(name = "trabajadores")
public class TrabajadorTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -6851503153734202407L;

	private int idTrabajador;
	private String nombre;
	private ClasificacionPuestoTO clasificacion;
	private byte[] huella;

	public TrabajadorTO() {
	}

	public TrabajadorTO(TrabajadorTO trabajador) {
		BeanUtils.copyProperties(trabajador, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_trabajador", unique = true, nullable = false)
	@XmlElement
	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria")
	@XmlElement
	public ClasificacionPuestoTO getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionPuestoTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Column(name = "huella")
	@XmlElement
	public byte[] getHuella() {
		return huella;
	}

	public void setHuella(byte[] huella) {
		this.huella = huella;
	}

	@Column(name = "nombre", unique = true, nullable = false, length = 200)
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
