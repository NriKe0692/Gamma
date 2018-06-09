package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/JSPF/JsCss.jspf");
    _jspx_dependants.add("/WEB-INF/JSPF/Top.jspf");
    _jspx_dependants.add("/WEB-INF/JSPF/Bottom.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"icon\" href=\"Recursos/img/web-logo-ico.ico\" spellcheck=\"\" />\n");
      out.write("        <title>Gamma Application</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!--bootstrap-->\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"Recursos/JQuery/jquery-3.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("<link href=\"Recursos/BootsTrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<script src=\"Recursos/BootsTrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<link href=\"Recursos/BootsTrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"Recursos/BootsTrap/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!--Estilos-->\n");
      out.write("<link href=\"Recursos/Css/index/Css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"Recursos/Css/index/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"Recursos/Css/CssBarraSocial.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"Recursos/Css/Cssjspf.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"Recursos/Css/fonts.css\" rel=\"stylesheet\" type=\"text/css\"/>");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"jPanelMenu-panel\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"content\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <body>  \n");
      out.write("        \n");
      out.write("        <div class=\"titulologin\">\n");
      out.write("            <h2>LOGIN</h2>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container login\" >\n");
      out.write("            <form action =\"loginusuario\" method=\"post\">\n");
      out.write("            <input type=\"text\"    name=\"user\" maxlength=\"8\" placeholder=\"usuario\" ><br>\n");
      out.write("            <input type=\"password\"  name=\"pass\" maxlength=\"40\" placeholder=\"contraseña\" ><br>\n");
      out.write("            <input type=\"submit\" name=\"btnRegistrar\"  value=\"INGRESAR\"   class=\"btn btn-primary \" >   \n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div class=\"logoempresa\">\n");
      out.write("                <img src=\"http://www.gamma.com.pe/wp-content/uploads/2015/01/web-logo.jpg\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"shadow\"></div>\n");
      out.write("\n");
      out.write("        <!--Barra de redes sociales-->\n");
      out.write("        <div class=\"social\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"http://www.gamma.com.pe/\" target=\"_blank\" class=\"icon-yahoo\" ></a></li>\n");
      out.write("                <li><a href=\"#\"  class=\"icon-google-plus\"></a></li>\n");
      out.write("                <li><a href=\"mailto:contacto@gamma.com.pe\" class=\"icon-mail\"> </a></li>\n");
      out.write("            </ul>   \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("    <footer id=\"footer\">\n");
      out.write("        <div>\n");
      out.write("        <small>\n");
      out.write("            <a>Developers</a><br>\n");
      out.write("            <div>\n");
      out.write("                <div>\n");
      out.write("                    <p >Tatiana Ayala Lozada | Celiz Polo Samantha</p>  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <a class=\"icon-facebook2\" href=\"http://www.gamma.com.pe/\"  target=\"_blank\"></a>\n");
      out.write("                    <a class=\"icon-google2\" href=\"mailto:developeraqc@gmail.com\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <a >Derechos Reservados &copy; 2017</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </small>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("</div>");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
