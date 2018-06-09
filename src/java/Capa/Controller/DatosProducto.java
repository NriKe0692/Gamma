package Capa.Controller;

import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.implement.ProductoDaoImplement;
import Capa.entity.Producto;
import java.io.BufferedReader;
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
public class DatosProducto extends HttpServlet {

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

        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;

        while ((str = br.readLine()) != null) {

            sb.append(str);

        }
        try {
            JSONObject jsonObj = new JSONObject(sb.toString());
            String serieproducto = jsonObj.getString("serieproducto");
            System.out.println("Mi producto es : " + serieproducto);

            ProductoDaoInterface productodao = new ProductoDaoImplement();
            Producto producto = new Producto();
//         ArrayList<Producto> lista = new ArrayList<Producto>();
            producto = productodao.ListarProductoSerie(serieproducto);
//        JSONArray jsonarray = new JSONArray();

            JSONObject json = new JSONObject();
            json.put("serieproducto", producto.getCodigoProd());
            json.put("proveedor", producto.getNombrePro());
            json.put("precio", producto.getPrecioventaProd());
            json.put("precioventa", producto.getPrecioventaProd());
            json.put("stock", producto.getStockProd());

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(json);

        } catch (Exception e) {
            
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
