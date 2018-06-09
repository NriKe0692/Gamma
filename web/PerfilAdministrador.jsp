
<%--<%@page import="Capa.entity.Usuario"%>--%>
<%-- 
    Document   : PerfilAdministrador
    Created on : 08-jun-2017, 14:53:56
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    String codigo = sesion.getAttribute("Codigo").toString();
    String nombre = sesion.getAttribute("Nombre").toString();
    String apellidop = sesion.getAttribute("Apellidop").toString();
    String apellidom = sesion.getAttribute("ApellidoM").toString();
    String direccion = sesion.getAttribute("Direccion").toString();
    String correo = sesion.getAttribute("Correo").toString();
    String telefono = sesion.getAttribute("Telefono").toString();
    String genero = sesion.getAttribute("Genero").toString();
    String tipo = sesion.getAttribute("Tipo").toString();


%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="icon" href="Recursos/img/web-logo-ico.ico" spellcheck="" />
        <title>Perfil Administrador</title>
        <%@include file="WEB-INF/JSPF/JsCssAdministrador.jspf" %>
    </head>
    <body ng-app="Myapp"> 
        <div class="jPanelMenu-panel">

            <div class="content">


                <div id="wrapper" >
                    <nav class="navbar navbar-default navbar-cls-top navcustom" role="navigation" style="margin-bottom: 0;">
                        <form action="logoutusuario" method="post">
                            <div  class="divSalir"> <script> var f = new Date(); document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());</script>&nbsp; 
                                <input class="btn btn-danger square-btn-adjust" type="submit" value="Salir">
                                <!--<a href="#" type="submit" class="btn btn-danger square-btn-adjust">Salir</a>-->
                            </div>
                        </form>

                    </nav>   

                    <!-- NAV Lista de Menu Administrador-->

                    <nav class="navbar-default navbar-side" role="navigation">
                        <div class="sidebar-collapse">
                            <ul class="nav" id="main-menu">
                                <li class="text-center">
                                    <img src="Recursos/img/admin.png" class="user-image img-responsive"/>
                                </li>
                                <li  onclick="mostrarinicio()">
                                    <a id="l1">
                                        <i class="icon-home"></i> Inicio</a>
                                </li>
                                <li  onclick="mostrarAdmiUsuario()">
                                    <a id="l2">
                                        <i class="icon-user"></i> Administrar Usuario 
                                    </a>

                                </li>

                                <li onclick="mostrarAdmiProveedor()">
                                    <a  id="l3">
                                        <i class="icon-user-tie"></i>Administrar Proveedores</a>
                                </li>	
                                <li onclick="mostrarAdmiProducto()">
                                    <a  id="l4">
                                        <i class="icon-cart"></i>Administrar Productos</a>
                                </li>	
                            </ul>

                        </div>

                    </nav>  



                    <!--Ventana Datos Administrador -->

                    <div id="s01" class=" c1" >
                        <div id="page-wrapper"  >
                            <div id="page-inner">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Administrador Gamma SAC</h2>   
                                        <h5>Bienvenido :<%=nombre%> </h5>
                                    </div>
                                </div>              

                                <div class="row" id="s01">
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Codigo</span>
                                            <input type="text" class="form-control" value="<%=codigo%>" placeholder="Codigo" disabled />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Nombre</span>
                                            <input type="text" class="form-control" value="<%=nombre%>" placeholder="Nombre" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Apellido</span>
                                            <input type="text" class="form-control" value="<%=apellidop + " " + apellidom%>" placeholder="Apellido" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Direccion</span>
                                            <input type="text" class="form-control" value="<%=direccion%>" placeholder="Direccion" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Correo</span>
                                            <input type="text" class="form-control" value="<%=correo%>" placeholder="Correo" disabled />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Telefono</span>
                                            <input type="text" class="form-control" value="<%=telefono%>" placeholder="Telefono" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Genero</span>
                                            <input type="text" class="form-control"  value="<%=genero%>" placeholder="Genero" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Tipo</span>
                                            <input type="text" class="form-control" value="<%=tipo%>"  placeholder="Tipo de Usuario" disabled/>
                                        </div>
                                    </div>

                                </div>    

                            </div>    

                        </div>
                    </div>

                    <!--Ventana Administar Usuario-->

                    <div id="s02" class=" c2">
                        <div id="page-wrapper" >
                            <div id="page-inner" ng-controller="adminUsuController">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Administrador Gamma SAC</h2>   
                                        <h5>Bienvenido :<%=nombre%> </h5>
                                    </div>
                                </div>              

                                <div class="row" id="s01">
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Codigo</span>
                                            <input type="text" class="form-control" id="txtcodigousu" maxlength="8" ng-model="nuevoUsuario.codigo" placeholder="Codigo Usuario" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Nombre</span>
                                            <input type="text" class="form-control" maxlength="40" id="txtnombreusu" ng-model="nuevoUsuario.nombre" placeholder="Nombre" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Apellido P.</span>
                                            <input type="text" class="form-control"maxlength="20" id="txtapellidopusu" ng-model="nuevoUsuario.apellidop" placeholder="Apellido Paterno" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Apellido M.</span>
                                            <input type="text" class="form-control" maxlength="20" id="txtapellidomusu" ng-model="nuevoUsuario.apellidom" placeholder="Apellido Materno" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Direccion</span>
                                            <input type="text" class="form-control"maxlength="40" id="txtdireccionusu"  ng-model="nuevoUsuario.direccion" placeholder="Direccion" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Correo</span>
                                            <input type="text" class="form-control"  maxlength="50" id="txtcorreousu" ng-model="nuevoUsuario.correo" placeholder="Correo" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Telefono</span>
                                            <input type="text" class="form-control" maxlength="9" id="txttelefonousu"  ng-model="nuevoUsuario.telefono" placeholder="Telefono" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Genero</span>
                                            <div class="form group">
                                                <select  ng-model="nuevoUsuario.genero" id="sltgenerousu" class="form-control" >
                                                     <option value="">--Selecciona el Genero--</option>
                                                    <option  value="M">Masculino</option>
                                                    <option   value="F">Femenino</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Clave</span>
                                            <input type="text" class="form-control" maxlength="35" id="txtclaveusu" ng-model="nuevoUsuario.clave" placeholder="Password" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Puesto</span>
                                            <input type="text" class="form-control" maxlength="30" id="txtpuestousu"  ng-model="nuevoUsuario.puesto" placeholder="Puesto Usuario" />
                                        </div>
                                    </div>

                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <button class="btn btn-warning" ng-click="registrarUsuario()">Registrar</button>

                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div id="pnlAlert1" class="alert alert-success">
                                            <strong>Exito </strong> {{MessageFaild}}
                                        </div>
                                        <div id="pnlAlert2" class="alert alert-danger">
                                            <strong>Error </strong> {{MessageFaild}}
                                        </div>
                                    </div>
                                </div> 
                                <!--Tabla responsive datos ussuario-->
                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <!--    Striped Rows Table  -->
                                        <div class="panel panel-default" >
                                            <div class="panel-heading">
                                                <button  class="btn btn-danger" ng-click="Listar()">Listar Usuario</button> 

                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive customtabla">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>Codigo</th>
                                                                <th>Nombre y Apellido</th>
                                                                <th>Direccion</th>
                                                                <th>Telefono</th>
                                                                <th>Puesto</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody ng-repeat="usuario in ArrayUsu">
                                                            <tr>

                                                                <td>{{usuario.codigo}}</td>
                                                                <td>{{usuario.nombre}} {{usuario.apellidop}} {{usuario.apellidom}}</td>
                                                                <td>{{usuario.direccion}}</td>
                                                                <td>{{usuario.telefono}}</td>
                                                                <td>{{usuario.puesto}}</td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--  End  Striped Rows Table  -->
                                    </div>


                                </div>    

                            </div>
                        </div>
                    </div>

                    <!--Ventan Administrar Proveedor-->

                    <div id="s03" class=" c3">
                        <div id="page-wrapper" >
                            <div id="page-inner" ng-controller="adminproveeController">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Administrador Gamma SAC</h2>   
                                        <h5>Bienvenido :<%=nombre%> </h5>
                                    </div>
                                </div>              

                                <div class="row">
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">RUC</span>
                                            <input type="text" class="form-control" maxlength="11"  id="txtrucprov" ng-model="nuevoProveedor.ruc"  placeholder="Ruc Proveedor" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Empresa</span>
                                            <input type="text" class="form-control" maxlength="40" id="txtempresaprov"  ng-model="nuevoProveedor.empresa" placeholder="Nombre de la Empresa" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Correo</span>
                                            <input type="text" class="form-control" maxlength="50"  id="txtcorreoprov" ng-model="nuevoProveedor.correo" placeholder="Correo de la Empresa" />
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Celular</span>
                                            <input type="text" class="form-control" maxlength="9"  id="txtcelularprov" ng-model="nuevoProveedor.telefono" placeholder="Celular de la Empresa" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Direccion</span>
                                            <input type="text" class="form-control" maxlength="40"  id="txtdireccionprov" ng-model="nuevoProveedor.direccion" placeholder="Direccion de la Empresa" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Distrito</span>
                                            <div class="form group">
                                                <select class="form-control" id="sltdistritoprov" ng-change="" ng-model="nuevoProveedor.distrito" >
                                                    <option value="">--Selecciona el distrito--</option>
                                                    <option ng-repeat="distrit in ArrayDestri">{{distrit.nombredistrito}}</option>
                                                </select>
                                                
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <button  class="btn btn-warning" ng-click="registrarNuevoProveedor()" >Registrar</button> 
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div id="pnlAlertproveedor1" class="alert alert-success">
                                            <strong>Exito </strong> {{MessageFaild}}
                                        </div>
                                        <div id="pnlproveedorAlert2" class="alert alert-danger">
                                            <strong>Error </strong> {{MessageFaild}}
                                        </div>
                                    </div>
                                </div>
                                <!--Tabla responsive datos usuario-->
                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <!--    Striped Rows Table  -->
                                        <div class="panel panel-default" >
                                            <div class="panel-heading">
                                                <button  class="btn btn-danger" ng-click="listarProveedor()" >Listar Proveedores</button> 

                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>RUC</th>
                                                                <th>Empresa</th>
                                                                <th>Correo</th>
                                                                <th>Celular</th>
                                                                <th>Direccion</th>
                                                                <th>Distrito</th>
                                                                <th>Estado</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody ng-repeat="proveedor in ArrayProveedor">
                                                            <tr>
                                                                <td>{{proveedor.ruc}}</td>
                                                                <td>{{proveedor.empresa}}</td>
                                                                <td>{{proveedor.correo}}</td>
                                                                <td>{{proveedor.telefono}}</td>
                                                                <td>{{proveedor.direccion}}</td>
                                                                <td>{{proveedor.distrito}}</td>
                                                                <td>{{proveedor.estado}}</td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>    

                            </div>
                        </div>
                    </div>

                    <!--Ventana Administrar Producto-->

                    <div id="s04" class=" c4">
                        <div id="page-wrapper" >
                            <div id="page-inner" ng-controller="adminProductoController">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h2>Administrador Gamma SAC</h2>   
                                        <h5>Bienvenido :<%=nombre%> </h5>
                                    </div>
                                    <div class="col-md-6">
                                        <h1>Grupos Electrógenos</h1>   
                                        <!--<h5>Bienvenido :<%=nombre%> </h5>-->
                                    </div>
                                </div>              

                                <div class="row">
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Serie</span>
                                            <input type="text"  class="form-control" id="txtserie" maxlength="10"  ng-model="nuevoProducto.codigo"placeholder="Serie de producto" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Motor</span>
                                            <input type="text" class="form-control" id="txtmotor" maxlength="40"  ng-model="nuevoProducto.motor" placeholder="Codigo de Motor" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Alternador</span>
                                            <input type="text" class="form-control" id="txtalternador" maxlength="40"  ng-model="nuevoProducto.alternador" placeholder="Codigo de Alternador" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Precio</span>
                                            <input type="text" class="form-control" id="txtprecio" maxlength="6"  ng-model="nuevoProducto.precio"placeholder="Precio de Producto" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Precio de venta</span>
                                            <input type="text" class="form-control" id="txtprecioventa" maxlength="6"  ng-model="nuevoProducto.precioventa" placeholder="Precio de Venta del producto" />
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Stock</span>
                                            <input type="text" class="form-control" id="txtstock" maxlength="7"  ng-model="nuevoProducto.stock" placeholder="Stock" />
                                        </div>
                                    </div>


                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Descripcion</span>
                                            <input type="text" class="form-control" id="txtdescripcion" maxlength="200"  ng-model="nuevoProducto.descripcion"placeholder="Descripcion del producto"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Proveedor</span>
                                            <div class="form group">
                                                <select class="form-control"  id="sltproveedor" ng-model="nuevoProducto.proveedor">
                                                    <option value="">--Selecciona el proveedor--</option>
                                                    <option ng-repeat=" proveedores in ArraydeProveedores">{{proveedores.empresa}}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Categoria</span>
                                            <div class="form group">
                                                <select class="form-control"  id="sltcategoria" ng-model="nuevoProducto.categoria">
                                                    <option>20 a 60KW</option>
                                                    <option>60 a 300KW</option>
                                                    <option>300KW a más</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <button  class="btn btn-warning" ng-click="registrarNuevoProducto()">Agregar</button> 

                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div id="pnlAlertproducto1" class="alert alert-success">
                                            <strong>Exito </strong> {{MessageFaild}}
                                        </div>
                                        <div id="pnlAlertproducto2" class="alert alert-danger">
                                            <strong>Error </strong> {{MessageFaild}}
                                        </div>
                                    </div>
                                </div>
                                <!--Tabla responsive datos usuario-->
                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <!--    Striped Rows Table  -->
                                        <div class="panel panel-default" >
                                            <div class="panel-heading">
                                                <button  class="btn btn-danger" ng-click="listarProductos()" >Listar Productos</button> 
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>Codigo</th>
                                                                <th>Motor</th>
                                                                <th>Alternador</th>
                                                                <th>Proveedor</th>
                                                                <th>Categoria</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody ng-repeat="producto in ArrayProducto">
                                                            <tr>
                                                                <td>{{producto.codigo}}</td>
                                                                <td>{{producto.motor}}</td>
                                                                <td>{{producto.alternador}}</td>
                                                                <td>{{producto.proveedor}}</td>
                                                                <td>{{producto.categoria}}</td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--  End  Striped Rows Table  -->
                                    </div>
                                </div>    

                            </div>
                        </div>
                    </div>    
                </div>
                <%@include file="WEB-INF/JSPF/Bottom.jspf" %>

                
            
            
            </body>


                </html>
