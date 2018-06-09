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
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
public class LoginUsuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String user, clave;
            user = request.getParameter("user");
            clave = request.getParameter("pass");
            String genero="";
            UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();
            Usuario usuario = usuariodao.LoginUsuario(user, clave);

            if (usuario.getTipoUsu() != null) {
                HttpSession session = request.getSession(true);
                 if(usuario.getGeneroUsu().equalsIgnoreCase("M")){
                     genero="Masculino";
                 }else{ genero="Femenino";}
                 
                session.setAttribute("Codigo", usuario.getCodigoUsu());
                session.setAttribute("Nombre", usuario.getNombreUsu());
                session.setAttribute("Apellidop", usuario.getApellpUsu());
                session.setAttribute("ApellidoM", usuario.getApellmUsu());
                session.setAttribute("Direccion", usuario.getDireccionUsu());
                session.setAttribute("Correo", usuario.getCorreoUsu());
                session.setAttribute("Telefono", usuario.getTelefonoUsu());
                session.setAttribute("Genero",genero);
                
                if ("A".equals(usuario.getTipoUsu())) {
                    session.setAttribute("Tipo","Administrador");
                    response.sendRedirect("PerfilAdministrador.jsp");
                } else {
                    if ("U".equals(usuario.getTipoUsu())) {
                        session.setAttribute("Tipo","Usuario");
                        response.sendRedirect("PerfilUsuario.jsp");
                    }
                }
            } else {
               
                response.sendRedirect("index.jsp");
            }
        }

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
