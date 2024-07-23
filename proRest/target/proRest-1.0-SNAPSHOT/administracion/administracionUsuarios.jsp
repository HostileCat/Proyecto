<%-- 
    Document   : administracionUsuarios
    Created on : 18/07/2024, 1:15:56 p. m.
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/proRest/css/administracionUsuario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <div class="main__nav">
                <ul class="nav__list">
                    
                    <li class="nav_item"><a href="/proRest/insertarOpcionesUsuario?opcion=cliente">Cliente</a></li>
                    <li class="nav_item"><a href="/proRest/insertarOpcionesUsuario?opcion=empleado">Empleado</a></li>
                    <%
                        if(rolUsuario == 1){
                            out.print("<li class='nav_item'><a href='/proRest/insertarOpcionesUsuario?opcion=administrador'>Administrador</a></li>");
                        }
                    %>
                    
                </ul>
            </div>
            <section class="section__container">
                <%
                    String titulo = (String) request.getAttribute("titulo");
                    
                    if(titulo != null){
                        out.print(titulo);
                    } else{
                        out.print("<h2 class='section__title'>Administración</h2>");
                    }
                %>
                <div class="grid__container" id="userGridContainer">
                    
                    <h3 class="grid__title">ID</h3>
                    <h3 class="grid__title">Nombre</h3>
                    <h3 class="grid__title">Correo</h3>
                    <h3 class="grid__title">Contraseña</h3>
                    <h3 class="grid__title">Rol</h3>
                    <h3 class="grid__title">Acciones</h3>
                    
                    <%
                            String fila = (String) request.getAttribute("fila");

                            if(fila != null){
                                out.print(fila);
                            }
                    %>
                </div>
            </section>
        </main>
        
        <script src="/proRest/js/script.js"></script>
    </body>
</html>
