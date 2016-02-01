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
@Table(name = "asistencias")
@XmlRootElement
public class AsistenciaTO implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = -6403579579160117790L;

	private int idAsistencia;
	private String fecha;
	private TrabajadorTO trabajador;
	private String horaEntrada;
	private String horaSalida;

	public AsistenciaTO() {

	}

	public AsistenciaTO(AsistenciaTO asistencia) {
		BeanUtils.copyProperties(asistencia, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_asistencia", unique = true, nullable = false)
	@XmlElement
	public int getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_trabajador")
	@XmlElement
	public TrabajadorTO getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(TrabajadorTO trabajador) {
		this.trabajador = trabajador;
	}

	@Column(name = "hora_entrada")
	@XmlElement
	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	@Column(name = "hora_salida")
	@XmlElement
	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	@Column(name = "fecha")
	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
