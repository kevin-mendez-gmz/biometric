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
@Table(name = "pase_produccion")
public class PaseProduccionTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6643762092839935555L;
    private int idPaseProduccion;
    private TipoCarneTO idTipoCarne;
    private float peso;
    private String fecha;
    private int numPiezas;
    private int lote;

    public PaseProduccionTO() {
    }

    public PaseProduccionTO(PaseProduccionTO pase) {
        BeanUtils.copyProperties(pase, this);
    }

    @Id
    @GeneratedValue
    @Column(name = "id_pase_produccion", unique = true, nullable = false)
    @XmlElement
    public int getIdPaseProduccion() {
        return idPaseProduccion;
    }

    public void setIdPaseProduccion(int idPaseProduccion) {
        this.idPaseProduccion = idPaseProduccion;
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
        return "PaseProduccionTO{" + "idPaseProduccion=" + idPaseProduccion
                + ", idTipoCarne=" + idTipoCarne + ", peso=" + peso
                + ", fecha=" + fecha + ", numPiezas=" + numPiezas + '}';
    }
}
