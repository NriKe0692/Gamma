
package Capa.dao.Interface;

import Capa.entity.Producto;
import java.util.ArrayList;

public interface ProductoDaoInterface {
    
     public abstract ArrayList<Producto> ListarProducto();
     public abstract void registrarProducto
        (String codigoprod,String motor,String alternador,double precioprod,double precioventapro,
     int stockprod,String descripcionprod, String proveedor,String categoriaprod);          
        public abstract void ActualizarStock(String serie, int cant, int tipo);
        public abstract Producto ListarProductoSerie( String serie);
        
}
