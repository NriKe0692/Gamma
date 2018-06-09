
package Capa.dao.implement;

import Capa.Conexion.Conexion;
import Capa.dao.Interface.ProductoDaoInterface;
import Capa.entity.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDaoImplement implements ProductoDaoInterface{
     Conexion mysql = new Conexion();
    @Override
    public ArrayList<Producto> ListarProducto() {
        
        ArrayList<Producto> lista=new ArrayList<Producto>();
        
        String query = ("{call SP_ListarProducto()}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
               Producto producto= new Producto();
               producto.setCodigoProd(rs.getString("serie"));
               producto.setCodigomotor(rs.getString("codMotor"));
               producto.setCodigoalternador(rs.getString("codAlternador"));
               producto.setPrecioProd(rs.getDouble("PrecioProd"));
               producto.setPrecioventaProd(rs.getDouble("precioventaProd"));
               producto.setStockProd(rs.getInt("stockProd"));
               producto.setDescripcionProd(rs.getString("descripcionProd"));
               producto.setEstadoProd(rs.getString("estadoProd"));
               producto.setNombrePro(rs.getString("nombrePro"));
               producto.setNombreCat(rs.getString("nombreCat"));
  
                lista.add(producto);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Producto : " + e.toString());
        } finally {
            mysql.desconectar();
        }
        
        return lista;
    
    }

    @Override
    public void registrarProducto(String codigoprod,String motor,String alternador,double precioprod,double precioventapro,int stockprod,String descripcionprod, String proveedor,String categoriaprod) {
        
         String query;
        query = ("{Call SP_RegistrarProductos('"+codigoprod+"','"+motor+"','"+alternador+"',"+precioprod+","+precioventapro+"," +stockprod+",'"+descripcionprod+"','"+ proveedor +"','" + categoriaprod +"')}");     


       mysql.ejecutar(query);
        mysql.desconectar();   
        
    
    }
    
    @Override
    public void ActualizarStock(String serie, int cant, int tipo){
        String query;
        query = ("{Call SP_ActualizarStock('"+serie+"',"+cant+","+tipo+")}");     


       mysql.ejecutar(query);
       mysql.desconectar();   
    }
    
    @Override
    public  Producto ListarProductoSerie(String serie){
            
        
        String query = ("{call SP_ListarProductoSerie('"+ serie+"')}");
    Producto producto= new Producto();
        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
               producto.setCodigoProd(rs.getString("serie"));
               producto.setCodigomotor(rs.getString("codMotor"));
               producto.setCodigoalternador(rs.getString("codAlternador"));
               producto.setPrecioProd(rs.getDouble("PrecioProd"));
               producto.setPrecioventaProd(rs.getDouble("precioventaProd"));
               producto.setStockProd(rs.getInt("stockProd"));
               producto.setDescripcionProd(rs.getString("descripcionProd"));
               producto.setEstadoProd(rs.getString("estadoProd"));
               producto.setNombrePro(rs.getString("nombrePro"));
               producto.setNombreCat(rs.getString("nombreCat"));
            }

        } catch (SQLException e) {
            System.out.println("Error Listar Producto : " + e.toString());
        } finally {
            mysql.desconectar();
        }
        
        return producto;
    }
}
