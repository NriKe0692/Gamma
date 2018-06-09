
package UsuarioimplementPrueba;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Proveedor;
import java.util.ArrayList;

public class ListarProveedor {

  
    public static void main(String[] args) {
       
         UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();

        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        System.out.println("    RUC  "+" EMPRESA  "+"   CORREO");
        lista = usuariodao.ListarProveedor();
        for (int i = 0; i < lista.size(); i++) {
            Proveedor proveedor = new Proveedor();
            proveedor = lista.get(i);
            System.out.println(""+proveedor.getRUCpro()+" "+proveedor.getNombrePro()+" "+proveedor.getCorreoPro());
        }
        
        
    }
    
}
