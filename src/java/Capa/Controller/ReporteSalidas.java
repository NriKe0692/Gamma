/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa.Controller;

import Capa.Conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Oscar Abad
 */
public class ReporteSalidas extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReporteEntradas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Tu reporte se ha creado</h1>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("PerfilUsuario.jsp");
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
              try {

            Conexion cn = new Conexion();
            Connection conexion = cn.conectar();

            String REPORT_PATH = "C:\\Users\\Oscar Abad\\Desktop\\Practicando\\ProyectoGamma\\GammaApplication\\web\\Recursos\\Reporte\\ReporteSalidas.jrxml";
            String REPORT_EXPORT_PATH = "C:\\Users\\Oscar Abad\\Desktop\\Practicando\\ProyectoGamma\\GammaApplication\\web\\PDFs\\ReporteSalidas.pdf";
            Map parameters = new HashMap();
//procediendo a compilar el reporte

            parameters.put("", "");
            JasperReport report = JasperCompileManager.compileReport(REPORT_PATH);
//cargando el reporte
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conexion);
//generando pdf

            JasperExportManager.exportReportToPdfFile(print, REPORT_EXPORT_PATH);
//visualizando el report

            JasperViewer.viewReport(print,true);

        } catch (Exception e) {
            System.out.println("Error reporte pdf " + e.toString());
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
