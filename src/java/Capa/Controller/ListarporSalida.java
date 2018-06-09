package Capa.Controller;

import Capa.dao.Interface.TransaccionDaoInterface;
import Capa.dao.implement.TransaccionDaoImplement;
import Capa.entity.Transaccion;
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
public class ListarporSalida extends HttpServlet {

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

        HttpSession sesion = request.getSession();
        String codigo = sesion.getAttribute("Codigo").toString();
        TransaccionDaoInterface transacciondao = new TransaccionDaoImplement();
        ArrayList<Transaccion> lista = new ArrayList<Transaccion>();
        JSONArray jsonArray = new JSONArray();

        lista = transacciondao.ListarSalidas(codigo);
        System.out.println("Cantidad de lista : " + lista.size());
        try {
            for (int i = 0; i < lista.size(); i++) {
                Transaccion transaccion = new Transaccion();
                JSONObject json = new JSONObject();
                transaccion = lista.get(i);
                json.put("fecha", transaccion.getFecha());
                json.put("nrofactura", transaccion.getNroFactura());
                json.put("fechafactura", transaccion.getFechaFactura());
                json.put("observaciones", transaccion.getObservaciones());
                json.put("serieproducto", transaccion.getSerie());
                json.put("tipo", transaccion.getTipo());
                json.put("costotrans", transaccion.getCostoTrans());
                json.put("proveedor", transaccion.getProveedor());
                json.put("destino", transaccion.getDestino());
                jsonArray.put(json);
            }

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonArray);

        } catch (Exception e) {
            System.out.println("Error en listar Transaccion " + e.toString());
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
