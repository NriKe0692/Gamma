/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsuarioimplementPrueba;

import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.Interface.TransaccionDaoInterface;
import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.ProductoDaoImplement;
import Capa.dao.implement.TransaccionDaoImplement;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Producto;
import Capa.entity.Transaccion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Oscar Abad
 */
public class ListarTransaccion {

    public static void main(String[] args) {

         TransaccionDaoInterface transacciondao= new TransaccionDaoImplement();
//        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();
//        System.out.println("      CODIGO  "+" NOMBRE PRODUCTO  "+"   PROVEEDOR ");
//        
//        lista = transacciondao.ListarSalidas("14200135");
//        for (int i = 0; i < lista.size(); i++) {
//            Transaccion trans= new Transaccion();
//            trans = lista.get(i);
//            System.out.println("     "+trans.getNroFactura()+"       "+trans.getDestino()+"    "+trans.getProveedor());
//        }
        Date fecha = new Date();
//        SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-YY");

         
//        System.out.println("fecha " + fecha);

//
        transacciondao.RegistrarTransaccion(fecha,"74000",fecha,"nada papu2","GPLS-12",10,10000,"14200123","",1);
    }

}
