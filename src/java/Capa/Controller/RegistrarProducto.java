package Capa.Controller;

import Capa.dao.Interface.ProductoDaoInterface;
import Capa.dao.implement.ProductoDaoImplement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
public class RegistrarProducto extends HttpServlet {

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

        ProductoDaoInterface productodao= new ProductoDaoImplement();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;

        while ((str = br.readLine()) != null) {

            sb.append(str);

        }
        try {
            JSONObject jsonObj = new JSONObject(sb.toString());
            String codigo = jsonObj.getString("codigo");
            String motor = jsonObj.getString("motor");
            String alternador = jsonObj.getString("alternador");
            String precio = jsonObj.getString("precio");
            String precioventa = jsonObj.getString("precioventa");
            String stock = jsonObj.getString("stock");
            String descripcion = jsonObj.getString("descripcion");
            String proveedor = jsonObj.getString("proveedor");
            String categoria = jsonObj.getString("categoria");
            
            double precio2 = Double.parseDouble(precio);
            double precioventa2 = Double.parseDouble(precioventa);
            int stock2 = Integer.parseInt(stock);
            
            productodao.registrarProducto(codigo, motor,alternador, precio2, precioventa2, stock2, descripcion, proveedor, categoria);
        
            JSONObject json = new JSONObject();

            json.put("codigo", codigo);
            json.put("motor", motor);
            json.put("alternador", alternador);
            json.put("precio", precio);
            json.put("precioventa", precioventa);
            json.put("stock", stock);
            json.put("descripcion", descripcion);
            json.put("proveedor", proveedor);
            json.put("categoria", categoria);
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
