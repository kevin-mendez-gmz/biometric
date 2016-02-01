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
@Table(name = "inventario_camaras")
public class HistorialCamaraTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 6667419874778005318L;
	private int idHistorial;
	private CamaraTO camaraTO;
	private TipoCarneTO idTipoCarne;
	private int numPiezas;
	private int lote;
	private int tarimas;
	private int estibas;
	private ProveedorTO proveedorTO;

	public HistorialCamaraTO() {
	}

	public HistorialCamaraTO(HistorialCamaraTO historial) {
		BeanUtils.copyProperties(historial, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_historial", unique = true, nullable = false)
	@XmlElement
	public int getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_camara")
	@XmlElement
	public CamaraTO getCamaraTO() {
		return camaraTO;
	}

	public void setCamaraTO(CamaraTO camaraTO) {
		this.camaraTO = camaraTO;
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

	@Column(name = "num_piezas")
	@XmlElement
	public int getNumPiezas() {
		return numPiezas;
	}

	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
	}

	@Column(name = "lote")
	@XmlElement
	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	@Column(name = "tarimas")
	@XmlElement
	public int getTarimas() {
		return tarimas;
	}

	public void setTarimas(int tarimas) {
		this.tarimas = tarimas;
	}

	@Column(name = "estibas")
	@XmlElement
	public int getEstibas() {
		return estibas;
	}

	public void setEstibas(int estibas) {
		this.estibas = estibas;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proveedor")
	@XmlElement
	public ProveedorTO getProveedorTO() {
		return proveedorTO;
	}

	public void setProveedorTO(ProveedorTO proveedorTO) {
		this.proveedorTO = proveedorTO;
	}

}
