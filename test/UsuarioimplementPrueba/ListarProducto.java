
package UsuarioimplementPrueba;

import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.implement.ProductoDaoImplement;
import Capa.entity.Producto;
import java.util.ArrayList;

public class ListarProducto {

  
    public static void main(String[] args) {
       
         ProductoDaoInterface productodao= new ProductoDaoImplement();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        System.out.println("      CODIGO  "+" NOMBRE PRODUCTO  "+"   PROVEEDOR ");
        
        lista = productodao.ListarProducto();
        for (int i = 0; i < lista.size(); i++) {
            Producto producto= new Producto();
            producto = lista.get(i);
            System.out.println("     "+producto.getCodigoProd()+"       "+producto.getNombrePro());
        }

        
    }
    
}
