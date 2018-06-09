
package Capa.entity;

public class Distrito {
    String nombreDistr;
    String estadoDist;

    public Distrito(){}
    
    public Distrito(String nombreDistr, String estadoDist) {
        this.nombreDistr = nombreDistr;
        this.estadoDist = estadoDist;
    }

    public String getNombreDistr() {
        return nombreDistr;
    }

    public String getEstadoDist() {
        return estadoDist;
    }

    public void setNombreDistr(String nombreDistr) {
        this.nombreDistr = nombreDistr;
    }

    public void setEstadoDist(String estadoDist) {
        this.estadoDist = estadoDist;
    }
    
    
}
