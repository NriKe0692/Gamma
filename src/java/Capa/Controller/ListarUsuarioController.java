/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.Controller;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Usuario;
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
public class ListarUsuarioController extends HttpServlet {

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

        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        JSONArray jsonArray = new JSONArray();
        lista = usuariodao.ListarUsuario();
        try {
            for (int i = 0; i < lista.size(); i++) {
                Usuario usuario = new Usuario();
                JSONObject json = new JSONObject();
                usuario = lista.get(i);
                json.put("codigo", usuario.getCodigoUsu());
                json.put("nombre", usuario.getNombreUsu());
                json.put("apellidop", usuario.getApellpUsu());
                json.put("apellidom", usuario.getApellmUsu());
                json.put("direccion", usuario.getDireccionUsu());
                json.put("telefono", usuario.getTelefonoUsu());
                json.put("puesto", usuario.getPuestoUsu());
                jsonArray.put(json);
            }
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonArray);

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
