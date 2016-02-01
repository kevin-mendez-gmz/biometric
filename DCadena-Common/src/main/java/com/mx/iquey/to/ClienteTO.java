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
@Table(name = "clientes")
public class ClienteTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6851503153734202407L;

	private int idCliente;
	private String nombre;
	private String apodo;
	private String telefono;
	private ZonaClienteTO idZona;

	public ClienteTO() {
	}

	public ClienteTO(ClienteTO cliente) {
		BeanUtils.copyProperties(cliente, this);
	}

	@Id
	@GeneratedValue
	@Column(name = "id_cliente", unique = true, nullable = false)
	@XmlElement
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apodo", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	@Column(name = "telefono", unique = true, nullable = false, length = 45)
	@XmlElement
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_zona")
	@XmlElement
	public ZonaClienteTO getIdZona() {
		return idZona;
	}

	public void setIdZona(ZonaClienteTO idZona) {
		this.idZona = idZona;
	}

	@Override
	public String toString() {
		return "ClienteTO [idCliente=" + idCliente + ", nombre=" + nombre
				+ ", apodo=" + apodo + ", telefono=" + telefono + "]";
	}
}
