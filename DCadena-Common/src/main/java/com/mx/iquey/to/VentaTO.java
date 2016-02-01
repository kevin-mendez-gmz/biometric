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
@Table(name = "ventas")
public class VentaTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 6667419874778005318L;
	private int idVenta;
	private ClienteTO idCliente;
	private TipoCarneTO idTipoCarne;
	private float peso;
	private float total;
	private String fecha;
	private int numPiezas;
	private int numCajas;
	private float pesoTara;
	private float precio;
	private int lote;

	public VentaTO() {
	}

	public VentaTO(VentaTO venta) {
		BeanUtils.copyProperties(venta, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_venta", unique = true, nullable = false)
	@XmlElement
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	@XmlElement
	public ClienteTO getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(ClienteTO idCliente) {
		this.idCliente = idCliente;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_carne")
	@XmlElement
	public TipoCarneTO getIdTipoCarne() {
		return idTipoCarne;
	}

	public void setIdTipoCarne(TipoCarneTO idTipoCarne) {
		this.idTipoCarne = idTipoCarne;
	}

	@Column(name = "peso")
	@XmlElement
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Column(name = "total")
	@XmlElement
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "fecha")
	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Column(name = "num_piezas")
	@XmlElement
	public int getNumPiezas() {
		return numPiezas;
	}

	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
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
	
	@Column(name = "lote")
	@XmlElement
	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return "VentaTO{" + "idVenta=" + idVenta + ", idCliente=" + idCliente
				+ ", idTipoCarne=" + idTipoCarne + ", peso=" + peso
				+ ", total=" + total + ", fecha=" + fecha + ", numPiezas="
				+ numPiezas + ", numCajas=" + numCajas + ", pesoTara="
				+ pesoTara + ", precio=" + precio + '}';
	}

}
