
package Capa.entity;

public class Producto {
    String codigoProd;
    String codigomotor;
    String codigoalternador;
    double PrecioProd;
    double precioventaProd;
    int stockProd;
    String descripcionProd;
    String estadoProd;
    String nombrePro;
    String nombreCat;

public Producto(){
    
}

  


    public Producto(String codigoProd, String codigomotor, String codigoalternador, double PrecioProd, double precioventaProd, int stockProd, String descripcionProd, String estadoProd, String nombrePro, String nombreCat) {
        this.codigoProd = codigoProd;
        this.codigomotor = codigomotor;
        this.codigoalternador = codigoalternador;
        this.PrecioProd = PrecioProd;
        this.precioventaProd = precioventaProd;
        this.stockProd = stockProd;
        this.descripcionProd = descripcionProd;
        this.estadoProd = estadoProd;
        this.nombrePro = nombrePro;
        this.nombreCat = nombreCat;
    }

    public String getCodigomotor() {
        return codigomotor;
    }

    public void setCodigomotor(String codigomotor) {
        this.codigomotor = codigomotor;
    }

    public String getCodigoalternador() {
        return codigoalternador;
    }

    public void setCodigoalternador(String codigoalternador) {
        this.codigoalternador = codigoalternador;
    }
    
    public String getCodigoProd() {
        return codigoProd;
    }

    public double getPrecioventaProd() {
        return precioventaProd;
    }

    public int getStockProd() {
        return stockProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public String getEstadoProd() {
        return estadoProd;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }
    public void setPrecioProd(double PrecioProd) {
        this.PrecioProd = PrecioProd;
    }
      public double getPrecioProd() {
        return PrecioProd;
    }

    public void setPrecioventaProd(double precioventaProd) {
        this.precioventaProd = precioventaProd;
    }

    public void setStockProd(int stockProd) {
        this.stockProd = stockProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public void setEstadoProd(String estadoProd) {
        this.estadoProd = estadoProd;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }
    

}
