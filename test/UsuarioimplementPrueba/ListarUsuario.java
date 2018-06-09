package UsuarioimplementPrueba;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Usuario;
import java.util.ArrayList;

public class ListarUsuario {

    public static void main(String[] args) {

        UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();

        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        System.out.println("    CODIGO  "+" NOMBRE  "+"   APELLIDO");
        lista = usuariodao.ListarUsuario();
        for (int i = 0; i < lista.size(); i++) {
            Usuario usuario = new Usuario();
            usuario = lista.get(i);
            System.out.println(""+usuario.getCodigoUsu()+" "+usuario.getNombreUsu()+" "+usuario.getApellpUsu());
        }

    }

}
