
package Capa.Controller;

import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.implement.ProductoDaoImplement;
import Capa.entity.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;


public class ListarProducto extends HttpServlet {

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
        
         ProductoDaoInterface productodao= new ProductoDaoImplement();
        ArrayList<Producto> lista = new ArrayList<Producto>();
        lista = productodao.ListarProducto();
        JSONArray jsonarray = new JSONArray();
        try {
            for (int i = 0; i < lista.size(); i++) {
                Producto producto= new Producto();
                JSONObject json = new JSONObject();
                producto = lista.get(i);
                json.put("codigo", producto.getCodigoProd());
                json.put("motor", producto.getCodigomotor());
                json.put("alternador", producto.getCodigoalternador());
                json.put("proveedor", producto.getNombrePro());
                json.put("categoria", producto.getNombreCat());
                json.put("precio", producto.getPrecioventaProd());
                json.put("precioventa", producto.getPrecioventaProd());
                json.put("stock", producto.getStockProd());
                json.put("descripcion", producto.getDescripcionProd());
                json.put("estado", producto.getEstadoProd());
        
                
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
