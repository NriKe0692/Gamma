
package Capa.dao.Interface;

import Capa.entity.Proveedor;
import Capa.entity.Usuario;
import java.util.ArrayList;


public interface UsuarioDaoInterface {
    
    public abstract Usuario LoginUsuario(String usuario,String password);
    public abstract ArrayList<Usuario> ListarUsuario();
    public abstract void RegistrarUsuario(String codigo,String nombre,String apellidop,String apellidom
    ,String direccion,String correo,String telefono,String genero,String password,String Puesto);
    public abstract void RegistrarProveedor(String RUCpro, String nombrePro, String correoPro, String telefonoPro, String direccionPro, String distrito);
    public abstract ArrayList<Proveedor> ListarProveedor();
}
