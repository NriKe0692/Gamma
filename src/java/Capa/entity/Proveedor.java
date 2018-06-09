/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.entity;

public class Proveedor {
    String RUCpro;
    String nombrePro;
    String correoPro;
    String telefonoPro;
    String direccionPro;
    String distrito;
    int estadoPro;

 public Proveedor(){}   
    
    public Proveedor(String RUCpro, String nombrePro, String correoPro, String telefonoPro, String direccionPro, String distrito, int estadoPro) {
        this.RUCpro = RUCpro;
        this.nombrePro = nombrePro;
        this.correoPro = correoPro;
        this.telefonoPro = telefonoPro;
        this.direccionPro = direccionPro;
        this.distrito = distrito;
        this.estadoPro = estadoPro;
    }

    public String getRUCpro() {
        return RUCpro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public String getCorreoPro() {
        return correoPro;
    }

    public String getTelefonoPro() {
        return telefonoPro;
    }

    public String getDireccionPro() {
        return direccionPro;
    }

    public String getDistrito() {
        return distrito;
    }

    public int getEstadoPro() {
        return estadoPro;
    }

    public void setRUCpro(String RUCpro) {
        this.RUCpro = RUCpro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public void setCorreoPro(String correoPro) {
        this.correoPro = correoPro;
    }

    public void setTelefonoPro(String telefonoPro) {
        this.telefonoPro = telefonoPro;
    }

    public void setDireccionPro(String direccionPro) {
        this.direccionPro = direccionPro;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setEstadoPro(int estadoPro) {
        this.estadoPro = estadoPro;
    }
    
    
}
