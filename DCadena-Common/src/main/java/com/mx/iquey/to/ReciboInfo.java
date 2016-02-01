/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.iquey.to;

import java.util.List;

/**
 *
 * @author Luis
 */
public class ReciboInfo {

    private String cliente;
    private List<VentaTO> ventasList;
    private List<DevolucionTO> devolucionesList;
    private float total;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<VentaTO> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<VentaTO> ventasList) {
        this.ventasList = ventasList;
    }

    public List<DevolucionTO> getDevolucionesList() {
        return devolucionesList;
    }

    public void setDevolucionesList(List<DevolucionTO> devolucionesList) {
        this.devolucionesList = devolucionesList;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    

}
