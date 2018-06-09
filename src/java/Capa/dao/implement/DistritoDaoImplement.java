
package Capa.dao.implement;

import Capa.Conexion.Conexion;
import Capa.dao.Interface.DistritoDaoInterface;
import Capa.entity.Distrito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DistritoDaoImplement implements DistritoDaoInterface{
    Conexion mysql = new Conexion();
    @Override
     public  ArrayList<Distrito> ListarDistrito(){
          ArrayList<Distrito> lista=new ArrayList<Distrito>();
        
        String query = ("{call SP_ListarDistrito()}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
               Distrito distrito= new Distrito();
               distrito.setNombreDistr(rs.getString("nombreDistr"));
               distrito.setEstadoDist(rs.getString("estadoDist"));

  
                lista.add(distrito);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Distrito : " + e.toString());
        } finally {
            mysql.desconectar();
        }
        
        return lista;
     }
}
