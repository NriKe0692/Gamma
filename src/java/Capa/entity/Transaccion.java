/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.entity;

import java.sql.Date;

public class Transaccion {
    Date fecha;
    String nroFactura;
    Date fechaFactura;
    String observaciones;
    String serie; 
    int cantidad;
    String tipo;
    double CostoTrans;
    String Proveedor;
    String Destino;
    
    
    public Transaccion(){        
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getSerie() {
        return serie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCostoTrans() {
        return CostoTrans;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public String getDestino() {
        return Destino;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCostoTrans(double CostoTrans) {
        this.CostoTrans = CostoTrans;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

   
    
}
