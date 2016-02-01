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
@Table(name = "inventario")
public class InventarioTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2815836583325729337L;

    private int idInventario;
    private TipoCarneTO idTipoCarne;
    private float cantidadKG;
    private int cantidadPiezas;
    private int lote;
    private String comentario;
    private String fecha;

    public InventarioTO() {
    }

    public InventarioTO(InventarioTO inventario) {
        BeanUtils.copyProperties(inventario, this);
    }

    @Id
    @GeneratedValue
    @Column(name = "id_inventario", unique = true, nullable = false)
    @XmlElement
    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
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

    @Column(name = "cantidad_kg")
    @XmlElement
    public float getCantidadKG() {
        return cantidadKG;
    }

    public void setCantidadKG(float cantidadKG) {
        this.cantidadKG = cantidadKG;
    }

    @Column(name = "cantidad_piezas")
    @XmlElement
    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    @Column(name = "lote")
    @XmlElement
    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    @Column(name = "comentario")
    @XmlElement
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
