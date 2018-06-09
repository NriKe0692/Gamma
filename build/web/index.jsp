<%-- 
    Document   : index
    Created on : Jun 7, 2017, 4:51:48 PM
    Author     : Oscar Abad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="Recursos/img/web-logo-ico.ico" spellcheck="" />
        <title>Gamma Application</title>
        <%@include file="WEB-INF/JSPF/JsCss.jspf"%>

    </head>
    
    <%@include file="WEB-INF/JSPF/Top.jspf"%>
    
    <body>  
        
        <div class="titulologin">
            <h2>LOGIN</h2>
        </div>

        <div class="container login" >
            <form action ="loginusuario" method="post">
            <input type="text"    name="user" maxlength="8" placeholder="usuario" ><br>
            <input type="password"  name="pass" maxlength="40" placeholder="contraseña" ><br>
            <input type="submit" name="btnRegistrar"  value="INGRESAR"   class="btn btn-primary " >   
            </form>

            <div class="logoempresa">
                <img src="http://www.gamma.com.pe/wp-content/uploads/2015/01/web-logo.jpg">
            </div>
        </div>

        <div class="shadow"></div>

        <!--Barra de redes sociales-->
        <div class="social">
            <ul>
                <li><a href="http://www.gamma.com.pe/" target="_blank" class="icon-yahoo" ></a></li>
                <li><a href="#"  class="icon-google-plus"></a></li>
                <li><a href="mailto:contacto@gamma.com.pe" class="icon-mail"> </a></li>
            </ul>   
        </div>

    </body>
    <%@include file="WEB-INF/JSPF/Bottom.jspf" %>
</html>

