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
@Table(name = "pesadas")
public class PesadaTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 6667419874778005318L;
	private int idPesada;
	private TipoCarneTO idTipoCarne;
	private float pesoInicial;
	private String fecha;
	private int numPiezas;
	private float pesoFinal;
	private float merma;
	private TaraTO idTara;

	public PesadaTO() {
	}

	public PesadaTO(PesadaTO pesada) {
		BeanUtils.copyProperties(pesada, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_pesada", unique = true, nullable = false)
	@XmlElement
	public int getIdPesada() {
		return idPesada;
	}

	public void setIdPesada(int idPesada) {
		this.idPesada = idPesada;
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

	@Column(name = "peso_inicial")
	@XmlElement
	public float getPesoInicial() {
		return pesoInicial;
	}

	public void setPesoInicial(float pesoInicial) {
		this.pesoInicial = pesoInicial;
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

	@Column(name = "peso_final")
	@XmlElement
	public float getPesoFinal() {
		return pesoFinal;
	}

	public void setPesoFinal(float pesoFinal) {
		this.pesoFinal = pesoFinal;
	}

	@Column(name = "merma")
	@XmlElement
	public float getMerma() {
		return merma;
	}

	public void setMerma(float merma) {
		this.merma = merma;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tara")
	@XmlElement
	public TaraTO getIdTara() {
		return idTara;
	}

	public void setIdTara(TaraTO idTara) {
		this.idTara = idTara;
	}

	@Override
	public String toString() {
		return "PesadaTO{" + "idPesada=" + idPesada + ", idTipoCarne="
				+ idTipoCarne + ", pesoInicial=" + pesoInicial + ", fecha="
				+ fecha + ", numPiezas=" + numPiezas + ", pesoFinal="
				+ pesoFinal + ", merma=" + merma + ", idTara=" + idTara + '}';
	}
}
