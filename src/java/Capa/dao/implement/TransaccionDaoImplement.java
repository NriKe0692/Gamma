/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.dao.implement;

import Capa.Conexion.Conexion;
import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.Interface.TransaccionDaoInterface;
import Capa.entity.Transaccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TransaccionDaoImplement implements TransaccionDaoInterface {
Conexion mysql = new Conexion();
    @Override
    public ArrayList<Transaccion> ListarTransaccion() {

        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

        String query = ("{call SP_ListarTransaccion()}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setNroFactura(rs.getString("nrofactura"));
                transaccion.setFechaFactura(rs.getDate("fechaFactura"));
                transaccion.setObservaciones(rs.getString("observaciones"));
                transaccion.setSerie(rs.getString("serie"));
                transaccion.setTipo(rs.getString("tipo"));
                transaccion.setCostoTrans(rs.getDouble("CostoTrans"));
                if(rs.getString("proveedor")==null){
                   transaccion.setProveedor("-"); 
                }else {transaccion.setProveedor(rs.getString("proveedor"));}
                
                if(rs.getString("destino")==null){
                   transaccion.setDestino("-"); 
                }else {transaccion.setDestino(rs.getString("destino"));}
                lista.add(transaccion);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Transaccion : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return lista;
    }
    public  ArrayList<Transaccion> ListarEntradas(String usu){
        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

        String query = ("{call SP_ListarEntradas('"+usu+"')}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setNroFactura(rs.getString("nrofactura"));
                transaccion.setFechaFactura(rs.getDate("fechaFactura"));
                transaccion.setObservaciones(rs.getString("observaciones"));
                transaccion.setSerie(rs.getString("serie"));
                transaccion.setTipo(rs.getString("tipo"));
                transaccion.setCostoTrans(rs.getDouble("CostoTrans"));
                transaccion.setProveedor(rs.getString("proveedor"));
                transaccion.setDestino("-");
                lista.add(transaccion);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Transaccion : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return lista;
    }
    @Override
    public  ArrayList<Transaccion> ListarSalidas(String usu){
        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

        String query = ("{call SP_ListarSalidas('"+usu+"')}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setNroFactura(rs.getString("nrofactura"));
                transaccion.setFechaFactura(rs.getDate("fechaFactura"));
                transaccion.setObservaciones(rs.getString("observaciones"));
                transaccion.setSerie(rs.getString("serie"));
                transaccion.setTipo(rs.getString("tipo"));
                transaccion.setCostoTrans(rs.getDouble("CostoTrans"));
                transaccion.setProveedor("-");
                transaccion.setDestino(rs.getString("destino"));
                lista.add(transaccion);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Transaccion : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return lista;
    }
    
    @Override
    public ArrayList<Transaccion> ListarEntradasProveedor(String usu, String Prove) {


        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

        String query = ("{call SP_ListarEntradasProveedor('"+usu+"','"+Prove+"')}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setNroFactura(rs.getString("nrofactura"));
                transaccion.setFechaFactura(rs.getDate("fechaFactura"));
                transaccion.setObservaciones(rs.getString("observaciones"));
                transaccion.setSerie(rs.getString("serie"));
                transaccion.setTipo(rs.getString("tipo"));
                transaccion.setCostoTrans(rs.getDouble("CostoTrans"));
                transaccion.setProveedor(rs.getString("proveedor"));
                transaccion.setDestino("-");
                lista.add(transaccion);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Transaccion : " + e.toString());
        } finally {
            mysql.desconectar();
        }

        return lista;
    }

    public ArrayList<Transaccion> ListarSalidasDestino(String usu, String dest) {


        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();

        String query = ("{call SP_ListarSalidasDestino('"+usu+"','"+dest+"')}");

        try {
            ResultSet rs = mysql.consultar(query);
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setFecha(rs.getDate("fecha"));
                transaccion.setNroFactura(rs.getString("nrofactura"));
                transaccion.setFechaFactura(rs.getDate("fechaFactura"));
                transaccion.setObservaciones(rs.getString("observaciones"));
                transaccion.setSerie(rs.getString("serie"));
                transaccion.setTipo(rs.getString("tipo"));
                transaccion.setCostoTrans(rs.getDouble("CostoTrans"));
                transaccion.setProveedor("-");
                transaccion.setDestino(rs.getString("destino"));
                lista.add(transaccion);

            }

        } catch (SQLException e) {
            System.out.println("Error Listar Transaccion : " + e.toString());
        } finally {
            mysql.desconectar();
        }
        return lista;
    }
    
    @Override
     public void RegistrarTransaccion(Date fecha, String nroFactura, Date fechaFactu, String Observ, String serie, int cant, double cost, String codusu, String destino, int tipo){
         String query;
        Date date = fecha;
        long d = date.getTime();
        java.sql.Date fechaparseada = new java.sql.Date(d);
        Date date2 = fechaFactu;
        long d2 = date2.getTime();
        java.sql.Date fechaparseada2 = new java.sql.Date(d2);
        
        ProductoDaoInterface productodao= new ProductoDaoImplement();
        
        query = ("{Call SP_RegistrarTransaccion('"+fechaparseada+"','"+nroFactura+"','"+fechaparseada2+"','"+Observ+"','"+serie+"'," +cant+","+cost+",'"+ codusu +"','" + destino +"'," + tipo +")}");     
        productodao.ActualizarStock(serie, cant, tipo);

       mysql.ejecutar(query);
       mysql.desconectar();   
     }
     
     
}
