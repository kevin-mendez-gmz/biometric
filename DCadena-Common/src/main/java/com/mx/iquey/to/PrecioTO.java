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
@Table(name = "precios")
public class PrecioTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4863333783069374083L;
	private int idPrecio;
	private ClienteTO cliente;
	private TipoCarneTO tipoCarne;
	private float precio;

	public PrecioTO() {
	}

	public PrecioTO(PrecioTO precio) {
		BeanUtils.copyProperties(precio, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_precio", unique = true, nullable = false)
	@XmlElement
	public int getIdPrecio() {
		return idPrecio;
	}

	public void setIdPrecio(int idPrecio) {
		this.idPrecio = idPrecio;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	@XmlElement
	public ClienteTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTO cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_carne")
	@XmlElement
	public TipoCarneTO getTipoCarne() {
		return tipoCarne;
	}

	public void setTipoCarne(TipoCarneTO tipoCarne) {
		this.tipoCarne = tipoCarne;
	}

	@Column(name = "precio")
	@XmlElement
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
