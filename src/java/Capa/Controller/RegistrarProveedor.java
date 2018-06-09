package Capa.Controller;

import Capa.dao.Interface.UsuarioDaoInterface;
import Capa.dao.implement.UsuarioDaoImplement;
import Capa.entity.Proveedor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
public class RegistrarProveedor extends HttpServlet {

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
        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
        String str = null;

        while ((str = br.readLine()) != null) {

            sb.append(str);

        }
        try {
            JSONObject jsonObj = new JSONObject(sb.toString());
            String ruc = jsonObj.getString("ruc");
            String empresa = jsonObj.getString("empresa");
            String correo = jsonObj.getString("correo");
            String telefono = jsonObj.getString("telefono");
            String direccion = jsonObj.getString("direccion");
            String distrito = jsonObj.getString("distrito");

            usuariodao.RegistrarProveedor(ruc, empresa, correo, telefono, direccion, distrito);

            JSONObject json = new JSONObject(); 

            json.put("ruc", ruc);
            json.put("empresa", empresa);
            json.put("correo", correo);
            json.put("telefono", telefono);
            json.put("direccion", direccion);
            json.put("distrito", distrito);
            json.put("estado", 1);

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
