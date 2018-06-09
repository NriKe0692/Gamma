package Capa.Controller;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class RegistrarUsuario extends HttpServlet {

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

        UsuarioDaoInterface usuariodao = new UsuarioDaoImplement();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String str = null;
        
        while ((str = br.readLine()) != null) {

            sb.append(str);

        }
        try {
            JSONObject jsonObj = new JSONObject(sb.toString());
            String codigo = jsonObj.getString("codigo");
            String nombre = jsonObj.getString("nombre");
            String apellidop = jsonObj.getString("apellidop");
            String apellidom = jsonObj.getString("apellidom");
            String direccion = jsonObj.getString("direccion");
            String correo = jsonObj.getString("correo");
            String telefono = jsonObj.getString("telefono");
            String genero = jsonObj.getString("genero");
            String clave = jsonObj.getString("clave");
            String puesto = jsonObj.getString("puesto");

            usuariodao.RegistrarUsuario(codigo, nombre, apellidop, apellidom, direccion, correo, telefono, genero, clave, puesto);

            JSONObject json = new JSONObject();
      
               json.put("codigo", codigo);
                json.put("nombre",nombre);
                json.put("apellidop",apellidop );
                json.put("apellidom", apellidom);
                json.put("direccion",direccion );
                json.put("telefono", telefono);
                json.put("puesto",puesto);
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
