
package UsuarioimplementPrueba;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;


public class Registrarusu {

   
    public static void main(String[] args) {
        
      UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();
      
        usuariodao.RegistrarUsuario("14200128", "Juan","alberto","moko","Konoha", "aspire@gmail.com", "9856345", "M", "242424","Almacenero");
        
        
        
    }
    
}
