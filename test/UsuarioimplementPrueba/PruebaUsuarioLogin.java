
package UsuarioimplementPrueba;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Usuario;


public class PruebaUsuarioLogin {

    public static void main(String[] args) {
        
       // UsuarioDaoInterface usuariodao= new UsuarioDaoImplement();
        //Usuario usuario= new Usuario();
        UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();
         Usuario usuario = usuariodao.LoginUsuario("14200135", "654321");
        //usuario=usuariodao.LoginUsuario("1420498","123456");
        
        System.out.println("        CODIGO "+"  NOMBRE"+"   APELLIDO PATERNO");
        System.out.println("     "+usuario.getCodigoUsu()+"    "+usuario.getNombreUsu()+"     "+usuario.getApellpUsu());
//      System.out.println(usuario);
            
        
        
    }
    
}
