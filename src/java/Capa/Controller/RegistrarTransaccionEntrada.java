/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.Controller;

import Capa.dao.Interface.TransaccionDaoInterface;
import Capa.dao.implement.TransaccionDaoImplement;
import Capa.entity.Transaccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
public class RegistrarTransaccionEntrada extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession sesion = request.getSession();
    String codigo = sesion.getAttribute("Codigo").toString();
       
        TransaccionDaoInterface transacciondao= new TransaccionDaoImplement();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();
        String str = null;

        while ((str = br.readLine()) != null) {

            sb.append(str);

        }
        try {
            JSONObject jsonObj = new JSONObject(sb.toString());
            
            String nrofactura = jsonObj.getString("nrofactura");
            //String stock = jsonObj.getString("stock");
            String inventrada = jsonObj.getString("inventarioentrada");
            String fechafactura = jsonObj.getString("fechafactura");
            String observacion = jsonObj.getString("observaciones");
            String serie = jsonObj.getString("serieproducto");
            String destino = "no hay";
            String proveedor = jsonObj.getString("proveedor");
            Double precio = jsonObj.getDouble("precio");
            
           /// String codigousu;
            Date fecha = new Date();
              SimpleDateFormat formatofecha = new SimpleDateFormat("dd-MM-YY");
              Date fechafac=formatofecha.parse(fechafactura);
            transacciondao.RegistrarTransaccion(fecha, nrofactura,fechafac, observacion, serie, Integer.parseInt(inventrada), (precio*Integer.parseInt(inventrada)), codigo, destino,1);

            JSONObject json = new JSONObject(); 

            json.put("fechaentrada", formatofecha.format(fecha));
            json.put("fecha",fechafactura );
            json.put("tipo", "Entrada");
            json.put("serieproducto", serie);
            json.put("proveedor", proveedor);
            json.put("destino", "No hay");
            json.put("nrofactura", nrofactura);
            json.put("fechafactura", fechafactura);
            json.put("cantidadentrada", inventrada);

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(json);

        } catch (Exception e) {
            System.out.println("ERROR : " + e.toString());
        }
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
