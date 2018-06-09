/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioimplementPrueba;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Usuario;
import java.util.ArrayList;

public class RegistrarProveedores {

    public static void main(String[] args) {
        UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();
//        System.out.println("    CODIGO  "+" NOMBRE  "+"   APELLIDO");
        usuariodao.RegistrarProveedor("7856491230", "Acer", "acer@gmail.com", "999632541", "Las Flores MzK lt3", "San Miguel");
    }
    
}
