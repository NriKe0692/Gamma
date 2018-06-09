<%-- 
    Document   : PerfilUsuario
    Created on : 08-jun-2017, 14:54:18
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
        <link rel="icon" href="Recursos/img/web-logo-ico.ico" spellcheck="" />
        <title>Perfil Usuario</title>
        <%@include file="WEB-INF/JSPF/JsCssUsuario.jspf"%>
    </head>
    <body ng-app="app">
        <div class="jPanelMenu-panel">
            <div class="content">
                <div id="wrapper">
                    <nav class="navbar navbar-default navbar-cls-top navcustom" role="navigation" style="margin-bottom: 0;">
                        <form action="logoutusuario" method="post">
                            <div  class="divSalir"> <script> var f = new Date(); document.write(f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear());</script>&nbsp; 
                                <input class="btn btn-danger square-btn-adjust" type="submit" value="Salir">
                                <!--<a href="#" type="submit" class="btn btn-danger square-btn-adjust">Salir</a>-->
                            </div>
                        </form>
                    </nav>   

                    <nav class="navbar-default navbar-side" role="navigation">
                        <div class="sidebar-collapse">
                            <ul class="nav" id="main-menu">
                                <li class="text-center">
                                    <img src="Recursos/img/admin.png" class="user-image img-responsive"/>
                                </li>
                                <li onclick="inicio()">
                                    <a id="l1">
                                        <i class="icon-home"></i> Inicio</a>
                                </li>
                                <li  onclick="VerTransacciones()">
                                    <a id="l2">
                                        <i class="icon-paste"></i> Ver Transacciones
                                    </a>
                                </li>	
                                <li  onclick="RealizarTransaccion()">
                                    <a id="l3"><i class="icon-hammer2"></i> Transacciones</a>
                                    <ul class="nav nav-second-level">
                                        <li>
                                            <a href="#"onclick="Entradas()" >Realizar Transacciones de Entrada</a>
                                        </li>
                                        <li>
                                            <a href="#"onclick="Salidas()">Realizar Transacciones de Salida</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>

                        </div>

                    </nav> 

                    <!--Vizualizar Datos del Usuario-->

                    <div id="s01" class=" c1" >
                        <div id="page-wrapper"  >
                            <div id="page-inner">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Usuario Gamma SAC</h2>   
                                        <h5>Bienvenid@: <%=nombre%> </h5>
                                    </div>
                                </div>              

                                <div class="row" id="s01">
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Codigo</span>
                                            <input type="text" class="form-control" value="<%=codigo%>" placeholder="Codigo" disabled/>
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
                                            <span class="input-group-addon">Dirección</span>
                                            <input type="text" class="form-control" value="<%=direccion%>" placeholder="Direccion" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Correo</span>
                                            <input type="text" class="form-control" value="<%=correo%>" placeholder="Correo" disabled/>
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
                                            <input type="text" class="form-control" value="<%=genero%>" placeholder="Genero" disabled/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Tipo</span>
                                            <input type="text" class="form-control" value="<%=tipo%>" placeholder="Tipo de Usuario" disabled/>
                                        </div>
                                    </div>
                                </div>    
                            </div>    
                        </div>
                    </div>

                    <!---Vizualizar Transacciones-->   

                    <div id="s02" class=" c2" >
                        <div id="page-wrapper"  ng-controller="verTransaccionController" >
                            <div id="page-inner">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Usuario Gamma SAC</h2>   
                                        <h5>Ver por:</h5>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3 col-sm-6 col-xs-6">
                                        <div class="form-group input-group input-group-sm">
                                            <div class="form group">
                                                <label> Tipo</label>
                                                <select class="form-control" id="sltTipo" ng-model="filtro1.tipo" ng-change="filtrarPorTipo()">
                                                    <option value="Todos">Todos</option>
                                                    <option value="Entradas">Solo Entradas</option>
                                                    <option value="Salidas">Solo Salidas</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-3 col-sm-6 col-xs-6">
                                        <div class="form-group input-group input-group-sm">
                                            <div class="form group">
                                                <label> Proveedor</label>
                                                <select class="form-control" id="sltproveedor" ng-model="filtro.proveedor" ng-change="filtrarporProveedor()">
                                                    <option value="todos">Todos</option>
                                                    <option value="Perkins">Perkins</option>
                                                    <option value="Volvo">Volvo</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6 col-xs-6">
                                        <div class="form-group input-group input-group-sm">
                                            <div class="form group">
                                                <label> Destino</label>
                                                <select class="form-control" id="sltdestino" ng-model="filtro2.destino" ng-change="filtrarporDestino()">
                                                    <option value="todos">Todos</option>
                                                    <option value="Tottus">Tottus</option>
                                                    <option value="Plaza Vea">Plaza Vea</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                </div>



                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <div class="panel panel-default" >
                                            <div class="panel-heading ">
                                                <button  class="btn btn-danger" ng-click="listarTransaccion()">Listar Transaccion</button> 

                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>Nro Factura</th>
                                                                <th>Fecha</th>
                                                                <th>Tipo</th>
                                                                <th>N° de Serie del Producto</th>
                                                                <th>Proveedor</th> 
                                                                <th>Destino</th>                                                               
                                                            </tr>

                                                        </thead>
                                                        <tbody ng-repeat="transaccion in Arraytransaccion">
                                                            <tr>
                                                                <td>{{transaccion.nrofactura}}</td>
                                                                <td>{{transaccion.fecha}}</td>
                                                                <td>{{transaccion.tipo}}</td>
                                                                <td>{{transaccion.serieproducto}}</td>
                                                                <td>{{transaccion.proveedor}}</td>
                                                                <td>{{transaccion.destino}}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--  End  Striped Rows Table  -->
                                    </div>
                                </div>    
                                <div class="row">
                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <div class="form group">
                                                <form action="reporteEntradas" method="post">
                                                    <button  type="submit" class="btn btn-primary btn-report"><i class="icon-file-pdf"></i> Generar Reporte Entradas</button> 
                                                </form>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <div class="form group">
                                                <form action="reporteSalidas" method="post">
                                                    <button  type="submit" class="btn btn-primary btn-report" ><i class="icon-file-pdf"></i> Generar Reporte Salidas</button> 
                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>    
                        </div>
                    </div>


                    <!--Opciones para ingresar a las ventanas de entrada y salida -->

                    <div id="s03" class=" c3" >
                        <div id="page-wrapper"  >
                            <div id="page-inner">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Usuario Gamma SAC</h2>   
                                    </div>
                                </div>              

                                <div class="row" id="s03">

                                    <div class="col-md-3 col-sm-6 col-xs-6 Entrada">           
                                        <div class="panel panel-back noti-box pointer" onclick="Entradas()">
                                            <button class="icon-box bg-color-red set-icon" onclick="Entradas()"><i class="icon-arrow-down2"></i></button>
                                            <div class="text-box" >
                                                <p class="main-text" >Realizar Transacción de Entrada</p>
                                                <p class="text-muted">Entradas</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-3 col-sm-6 col-xs-6 Salida">           
                                        <div class="panel panel-back noti-box pointer" onclick="Salidas()">
                                            <button class="icon-box bg-color-green set-icon" onclick="Salidas()"><i class="icon-arrow-up2"></i></button>
                                            <div class="text-box"  >
                                                <p class="main-text" >Realizar Transacción de Salida</p>
                                                <p class="text-muted">Salidas</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>    
                            </div>    
                        </div>
                    </div>
                    <!-- Realizar transaccion de Entrada-->
                    <div id="s03subEntradas" class=" c3" >
                        <div id="page-wrapper" >
                            <div id="page-inner" ng-controller="transaccionentradaController" >
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Usuario Gamma SAC</h2>   
                                    </div>
                                </div>              

                                <div class="row" id="">

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Proveedor</span> 
                                            <input class="form-control" type="text" id="prove"  ng-model="nuevaTransaccionEntrada.proveedor" /> 

                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <!--ng-options="item.codigo as serieproducto for item in Arraydecodigos"--> 
                                            <span class="input-group-addon">N°de Serie del Producto</span>
                                            <div class="form group">
                                                <select class="form-control" id="producto1"  ng-change="buscarProducto()" ng-model="nuevaTransaccionEntrada.serieproducto">
                                                    <option value="">--Elige producto--</option>
                                                    <option ng-repeat=" codigos in Arraydecodigos">{{codigos.codigo}}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Stock</span>                                
                                            <input type="text" class="form-control" value="120" id="stock1" ng-model="nuevaTransaccionEntrada.stock"  />                                    
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Ingresan a inventario</span>                                   
                                            <input class="form-control"  type="text" id="numbinventariotran1"  ng-model="nuevaTransaccionEntrada.inventarioentrada" min="0" placeholder="0"/>
                                        </div>                                  
                                    </div>  
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Nro de Factura</span>                                   
                                            <input type="text" class="form-control" id="txtnroFacturatran1" ng-model="nuevaTransaccionEntrada.nrofactura"  maxlength="10" placeholder="0"/>
                                        </div>                                  
                                    </div>  
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Fecha de Factura</span>
                                            <input type="date" class="form-control" id="datefechaFactura1" ng-model="nuevaTransaccionEntrada.fechafactura" placeholder="Fecha"/>
                                        </div>                                 
                                    </div> 

                                    <div class="col-md-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Observaciones</span>
                                            <textarea class="form-control" rows="3" id="txtObservaciones1" ng-model="nuevaTransaccionEntrada.observaciones" value="" placeholder="Ingrese alguna observación"></textarea>
                                        </div>                                 
                                    </div>    
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div id="pnlAlerttransaccion1" class="alert alert-success">
                                            <strong>Exito </strong> {{MessageFaild}}
                                        </div>
                                        <div id="pnlAlerttransaccion2" class="alert alert-danger">
                                            <strong>Error </strong> {{MessageFaild}}
                                        </div>
                                    </div>

                                </div> 

                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <!--    Striped Rows Table  -->
                                        <div class="panel panel-default" >
                                            <div class="panel-heading">
                                                Transacción de Entrada
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                        <thead>
                                                            <tr>
                                                                <th>N° de Serie del Producto</th>
                                                                <th>Fecha de entrada</th>
                                                                <th>Proveedor</th>
                                                                <th>Cantidad Ingresada</th> 
                                                                <th>Nro Factura</th>
                                                                <th>Fecha de Factura</th>
                                                                <th></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody ng-repeat=" transaccionentrada in Arraytransaccionentrada">
                                                            <tr>
                                                            <tr>
                                                                <td>{{transaccionentrada.serieproducto}}</td>
                                                                <td>{{transaccionentrada.fechaentrada}}</td>
                                                                <td>{{transaccionentrada.proveedor}}</td>
                                                                <td>{{transaccionentrada.cantidadentrada}}</td>
                                                                <td>{{transaccionentrada.nrofactura}}</td>
                                                                <td>{{transaccionentrada.fechafactura}}</td>
                                                            </tr>
                                                            </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--  End  Striped Rows Table  -->
                                    </div>
                                </div>
                                <div class="row">       
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="row">                                    
                                            <div class="col-md-3 col-sm-6 col-xs-6">
                                                <button class="btn btn-primary registrarbtn" ng-click="registrarnuevaTransaccionEntrada()">
                                                    <i class="icon-folder-upload"></i>
                                                    REGISTRAR TRANSACCIÓN
                                                </button>
                                            </div> 
                                        </div>
                                    </div>
                                </div>  
                            </div>    
                        </div>    
                    </div>


                    <div id="s03subSalidas" class=" c3" >
                        <div id="page-wrapper"  >
                            <div id="page-inner" ng-controller="registrarTransaccionSalidaController">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h2>Usuario Gamma SAC</h2>   
                                    </div>
                                </div>              

                                <div class="row" id="">

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Destino</span>
                                            <div class="form group">
                                                <select class="form-control"  ng-model="nuevatransaccionSalida.destinosalida" id="sltdestinosalida">
                                                    <option value="Plaza Vea">Plaza Vea</option>
                                                    <option value="Tottus">Tottus</option>
                                                    <option value="Vivanda">Vivanda</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">N° de Serie del Producto</span>
                                            <div class="form group">
                                                <select class="form-control" id="producto" ng-model="nuevatransaccionSalida.serieproducto" ng-change="buscarProducto()">
                                                    <option value="">--Elige producto--</option>
                                                    <option ng-repeat=" codigos in Arraydecodigos">{{codigos.codigo}}</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Stock</span>                                   
                                            <input type="text"   class="form-control"  ng-model="nuevatransaccionSalida.stock" id="txtstockproductosalida"/>                                    
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Salen de inventario</span> 
                                            <input type="text" class="form-control"  ng-model="nuevatransaccionSalida.inventariosalida" id="txtinventariosalida"   min="1" max="144" placeholder="0"/>

                                        </div>                                 
                                    </div>

                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Nro de Factura</span>                                   
                                            <input type="text"  ng-model="nuevatransaccionSalida.nrofactura" id="txtnrofacturasalida" class="form-control"  maxlength="10" placeholder="0"/>
                                        </div>                                  
                                    </div>  
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Fecha de Factura</span>
                                            <input type="date"  ng-model="nuevatransaccionSalida.fechafactura" id="txtfechafacturasalida"class="form-control" placeholder="Fecha"/>
                                        </div>                                 
                                    </div> 
                                    <div class="col-md-12">
                                        <div class="form-group input-group input-group-sm">
                                            <span class="input-group-addon">Observaciones</span>
                                            <textarea class="form-control" ng-model="nuevatransaccionSalida.observaciones" id="txtobservacionessalida" rows="3" value="" placeholder="Ingrese alguna observación"></textarea>
                                        </div>                                 
                                    </div>  


                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div id="pnlAlerttransaccion4" class="alert alert-success" >
                                            <strong>Exito </strong> {{MessageFaild}}
                                        </div>
                                        <div id="pnlAlerttransaccion3" class="alert alert-danger" >
                                            <strong>Error </strong> {{MessageFaild}}
                                        </div>
                                    </div>


                                </div>
                                <div class="row">
                                    <div class="col-md-12 tabla-top" >
                                        <!--    Striped Rows Table  -->
                                        <div class="panel panel-default" >
                                            <div class="panel-heading">
                                                Transacción de Salida
                                            </div>
                                            <div class="panel-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th>Fecha de Salida</th>
                                                                <th>N° de Serie del Producto</th>                                                                
                                                                <th>Cantidad que sale</th> 
                                                                <th>Destino</th>
                                                                <th>Nro Factura</th>
                                                                <th>Fecha de Factura</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody ng-repeat=" transaccionsalida in Arraytransaccionsalida">
                                                            <tr>
                                                                <td>{{transaccionsalida.fechasalida}}</td>
                                                                <td>{{transaccionsalida.serieproducto}}</td>
                                                                <td>{{transaccionsalida.cantidadsalida}}</td>
                                                                <td>{{transaccionsalida.destino}}</td>
                                                                <td>{{transaccionsalida.nrofactura}}</td>
                                                                <td>{{transaccionsalida.fechafactura}}</td>
                                                            </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!--  End  Striped Rows Table  -->
                                    </div>
                                </div>   
                                <div class="row">   
                                    <div class="col-md-6 col-sm-12 col-xs-12">
                                        <div class="row">                                    
                                            <div class="col-md-3 col-sm-6 col-xs-6">
                                                <button class="btn btn-primary registrarbtn" ng-click="registrarnuevaTransaccionSalida()">
                                                    <i class="icon-folder-upload"></i>
                                                    REGISTRAR TRANSACCIÓN
                                                </button>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>    
                        </div>    
                    </div>
                </div>
                <%@include file="WEB-INF/JSPF/Bottom.jspf" %>
                </body>
                </html>
