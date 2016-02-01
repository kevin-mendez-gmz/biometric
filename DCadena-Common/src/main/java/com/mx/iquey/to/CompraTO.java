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
@Table(name = "compras")
public class CompraTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -2400231879669803902L;
	private int idCompra;
	private ProveedorTO idProveedor;
	private TipoCarneTO idTipoCarne;
	private float peso;
	private float total;
	private String fecha;
	private int numPiezas;
	private int numCajas;
	private float pesoTara;
	private boolean pagado;
	private float precio;

	public CompraTO() {
	}

	public CompraTO(CompraTO compra) {
		BeanUtils.copyProperties(compra, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_compra", unique = true, nullable = false)
	@XmlElement
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_proveedor")
	@XmlElement
	public ProveedorTO getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(ProveedorTO idProveedor) {
		this.idProveedor = idProveedor;
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

	@Column(name = "pagado")
	@XmlElement
	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	@Column(name = "precio")
	@XmlElement
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CompraTO{" + "idCompra=" + idCompra + ", idProveedor="
				+ idProveedor + ", idTipoCarne=" + idTipoCarne + ", peso="
				+ peso + ", total=" + total + ", fecha=" + fecha
				+ ", numPiezas=" + numPiezas + ", numCajas=" + numCajas
				+ ", pesoTara=" + pesoTara + ", pagado=" + pagado + ", precio="
				+ precio + '}';
	}
}
