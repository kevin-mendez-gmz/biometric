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
@Table(name = "tipo_carne")
@XmlRootElement
public class TipoCarneTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3967999212722913588L;

	private int idTipoCarne;
	private String tipoCarne;
	private boolean devoluciones;
	private boolean ventas;
	private boolean almacen;
	private boolean proveedores;
	private boolean frecuencia;
	private String nombreImprimir;

	public TipoCarneTO() {
	}

	public TipoCarneTO(TipoCarneTO tipoCarne) {
		BeanUtils.copyProperties(tipoCarne, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_tipo_carne", unique = true, nullable = false)
	@XmlElement
	public int getIdTipoCarne() {
		return idTipoCarne;
	}

	public void setIdTipoCarne(int idTipoCarne) {
		this.idTipoCarne = idTipoCarne;
	}

	@Column(name = "tipo_carne")
	@XmlElement
	public String getTipoCarne() {
		return tipoCarne;
	}

	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
	}

	@Column(name = "devoluciones")
	@XmlElement
	public boolean getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(boolean devoluciones) {
		this.devoluciones = devoluciones;
	}

	@Column(name = "ventas")
	@XmlElement
	public boolean getVentas() {
		return ventas;
	}

	public void setVentas(boolean ventas) {
		this.ventas = ventas;
	}

	@Column(name = "almacen")
	@XmlElement
	public boolean getAlmacen() {
		return almacen;
	}

	public void setAlmacen(boolean almacen) {
		this.almacen = almacen;
	}

	@Column(name = "proveedores")
	@XmlElement
	public boolean getProveedores() {
		return proveedores;
	}

	public void setProveedores(boolean proveedores) {
		this.proveedores = proveedores;
	}

	@Column(name = "frecuencia")
	@XmlElement
	public boolean getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(boolean frecuencia) {
		this.frecuencia = frecuencia;
	}

	@Column(name = "nombre_imprimir")
	@XmlElement
	public String getNombreImprimir() {
		return nombreImprimir;
	}

	public void setNombreImprimir(String nombreImprimir) {
		this.nombreImprimir = nombreImprimir;
	}

}
