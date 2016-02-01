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
@Table(name = "proveedores")
public class ProveedorTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 6667419874778005318L;
	private int idProveedor;
	private String nombre;

	public ProveedorTO() {
	}

	public ProveedorTO(ProveedorTO proveedor) {
		BeanUtils.copyProperties(proveedor, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_proveedor", unique = true, nullable = false)
	@XmlElement
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Column(name = "nombre")
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}