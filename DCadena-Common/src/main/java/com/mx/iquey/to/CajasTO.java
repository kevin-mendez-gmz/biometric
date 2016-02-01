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
@Table(name = "cantidad_taras")
public class CajasTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4011390224124644764L;
	private int idCantidad;
	private int cantidad;
	private String fecha;
	private TaraTO Tara;

	public CajasTO() {
	}

	public CajasTO(CajasTO cajas) {
		BeanUtils.copyProperties(cajas, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_cajas", unique = true, nullable = false)
	@XmlElement
	public int getIdCantidad() {
		return idCantidad;
	}

	public void setIdCantidad(int idCantidad) {
		this.idCantidad = idCantidad;
	}

	@Column(name = "cantidad")
	@XmlElement
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "fecha")
	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tara")
	@XmlElement
	public TaraTO getTara() {
		return Tara;
	}

	public void setTara(TaraTO tara) {
		Tara = tara;
	}
}
