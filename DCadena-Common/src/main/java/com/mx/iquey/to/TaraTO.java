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
@Table(name = "taras")
public class TaraTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4011390224124644764L;
	private int idTara;
	private String tara;
	private float peso;

	public TaraTO() {
	}

	public TaraTO(TaraTO tara) {
		BeanUtils.copyProperties(tara, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_tara", unique = true, nullable = false)
	@XmlElement
	public int getIdTara() {
		return idTara;
	}

	public void setIdTara(int idTara) {
		this.idTara = idTara;
	}

	@Column(name = "tara", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}

	@Column(name = "peso")
	@XmlElement
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
}
