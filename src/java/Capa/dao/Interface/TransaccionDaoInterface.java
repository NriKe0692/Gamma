/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.dao.Interface;

import Capa.entity.Transaccion;

import java.util.ArrayList;
import java.util.Date;

public interface TransaccionDaoInterface {
    public abstract ArrayList<Transaccion> ListarTransaccion();
    public abstract ArrayList<Transaccion> ListarEntradas(String usu);
    public abstract ArrayList<Transaccion> ListarSalidas(String usu);
    public abstract ArrayList<Transaccion> ListarEntradasProveedor(String usu, String Prove);
    public abstract ArrayList<Transaccion> ListarSalidasDestino(String usu, String dest);
    public abstract void RegistrarTransaccion(Date fecha, String nroFactura, Date fechaFactu, String Observ, String serie, int cant, double cost, String codusu, String destino, int tipo);
}
