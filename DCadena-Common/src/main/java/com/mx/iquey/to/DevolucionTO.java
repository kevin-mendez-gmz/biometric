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
@Table(name = "devoluciones")
@XmlRootElement
public class DevolucionTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -6403579579160117790L;

	private int idDev;
	private int numPiezas;
	private float peso;
	private TipoCarneTO tipoCarne;
	private String tipoDevolucion;
	private String fecha;
	private ClienteTO cliente;
	private int numCajas;
	private float pesoTara;
	private float precio;
	private float total;

	public DevolucionTO() {
	}

	public DevolucionTO(DevolucionTO devolucion) {
		BeanUtils.copyProperties(devolucion, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_dev", unique = true, nullable = false)
	@XmlElement
	public int getIdDev() {
		return idDev;
	}

	public void setIdDev(int idDev) {
		this.idDev = idDev;
	}

	@Column(name = "num_piezas")
	@XmlElement
	public int getNumPiezas() {
		return numPiezas;
	}

	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
	}

	@Column(name = "peso")
	@XmlElement
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
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

	@Column(name = "tipo_devolucion", length = 45)
	@XmlElement
	public String getTipoDevolucion() {
		return tipoDevolucion;
	}

	public void setTipoDevolucion(String tipoDevolucion) {
		this.tipoDevolucion = tipoDevolucion;
	}

	@Column(name = "fecha", length = 45)
	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	@Column(name = "num_cajas")
	@XmlElement
	public int getNumCajas() {
		return numCajas;
	}

	public void setNumCajas(int numCajas) {
		this.numCajas = numCajas;
	}

	@Column(name = "peso_tara")
	@XmlElement
	public float getPesoTara() {
		return pesoTara;
	}

	public void setPesoTara(float pesoTara) {
		this.pesoTara = pesoTara;
	}

	@Column(name = "precio")
	@XmlElement
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Column(name = "total")
	@XmlElement
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
