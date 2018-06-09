package Capa.dao.implement;

import Capa.Conexion.Conexion;
import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.entity.Proveedor;
import Capa.entity.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDaoImplement implements UsuarioDaoInterface {

    Conexion mysql = new Conexion();
//    private Conexion con;

    public UsuarioDaoImplement() {

    }

    @Override
    public Usuario LoginUsuario(String usuario, String password) {
        String query;
        query = ("{Call SP_Login('" + usuario + "','" + password + "')}");
        Usuario usu = new Usuario();

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                usu.setCodigoUsu(rs.getString("CodigoUsu"));
                usu.setNombreUsu(rs.getString("nombreUsu"));
                usu.setApellpUsu(rs.getString("apellpUsu"));
                usu.setApellmUsu(rs.getString("apellmUsu"));
                usu.setDireccionUsu(rs.getString("direccionUsu"));
                usu.setCorreoUsu(rs.getString("correoUsu"));
                usu.setTelefonoUsu(rs.getString("telefonoUsu"));
                usu.setGeneroUsu(rs.getString("generoUsu"));
                usu.setPuestoUsu(rs.getString("puestoUsu"));
                usu.setTipoUsu(rs.getString("tipoUsu"));

            }

        } catch (SQLException e) {
            System.out.println("Error Login : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return usu;
    }

    @Override
    public ArrayList<Usuario> ListarUsuario() {

        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String query;
        query = ("{Call SP_ListarUsuarios()}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setCodigoUsu(rs.getString("CodigoUsu"));
                usu.setNombreUsu(rs.getString("nombreUsu"));
                usu.setApellpUsu(rs.getString("apellpUsu"));
                usu.setApellmUsu(rs.getString("apellmUsu"));
                usu.setDireccionUsu(rs.getString("direccionUsu"));
                usu.setCorreoUsu(rs.getString("correoUsu"));
                usu.setTelefonoUsu(rs.getString("telefonoUsu"));
                usu.setGeneroUsu(rs.getString("generoUsu"));
                usu.setPuestoUsu(rs.getString("puestoUsu"));
                usu.setTipoUsu(rs.getString("tipoUsu"));

                lista.add(usu);

            }

        } catch (SQLException e) {
            System.out.println("Error Login : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return lista;

    }

    @Override
    public void RegistrarUsuario(String codigo, String nombre, String apellidop, String apellidom, String direccion, String correo, String telefono, String genero, String password, String Puesto) {

       String query;
        query = ("{Call SP_RegistrarUsuarios('" + codigo + "','" + nombre + "','" + apellidop +"','" + apellidom +"','" + direccion +"','" + correo +"','" + telefono +"','" + genero +"','" + password +"','" + Puesto +"')}");     
        mysql.ejecutar(query);
        mysql.desconectar();       
    }
    
    @Override
    public void RegistrarProveedor(String RUCpro, String nombrePro, String correoPro, String telefonoPro, String direccionPro, String distrito) {

       String query;
        query = ("{Call SP_RegistrarProveedores('" + RUCpro + "','" + nombrePro + "','" + correoPro +"','" + telefonoPro +"','" + direccionPro +"','" + distrito +"')}");     
        mysql.ejecutar(query);
        mysql.desconectar();       
    } 

    @Override
    public ArrayList<Proveedor> ListarProveedor() {
        ArrayList<Proveedor> lista= new ArrayList<Proveedor>();
        
        String query="{call SP_ListarProveedores()}";
          try {
            
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
            
                Proveedor proveedor= new Proveedor();
                proveedor.setRUCpro(rs.getString("RUCpro"));
                proveedor.setNombrePro(rs.getString("nombrePro"));
                proveedor.setCorreoPro(rs.getString("correoPro"));
                proveedor.setTelefonoPro(rs.getString("telefonoPro"));
                proveedor.setDireccionPro(rs.getString("direccionPro"));
                proveedor.setDistrito(rs.getString("nombreDistr"));
                proveedor.setEstadoPro(rs.getInt("estadoPro"));

                lista.add(proveedor);

            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    

}
