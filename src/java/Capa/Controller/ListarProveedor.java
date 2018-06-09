/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.Controller;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
public class ListarProveedor extends HttpServlet {

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

        UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();

        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        lista = usuariodao.ListarProveedor();
        JSONArray jsonarray = new JSONArray();
        try {
            for (int i = 0; i < lista.size(); i++) {
                Proveedor proveedor = new Proveedor();
                JSONObject json = new JSONObject();
                proveedor = lista.get(i);
                json.put("ruc", proveedor.getRUCpro());
                json.put("empresa", proveedor.getNombrePro());
                json.put("correo", proveedor.getCorreoPro());
                json.put("telefono", proveedor.getTelefonoPro());
                json.put("direccion", proveedor.getDireccionPro());
                json.put("distrito", proveedor.getDistrito());
                json.put("estado", proveedor.getEstadoPro());
                jsonarray.put(json);

            }
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonarray);

        } catch (Exception e) {
        }

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
