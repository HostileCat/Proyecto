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
        <title>Mis Reservas</title>
        <link rel="stylesheet" href="/proRest/css/administracionReservas.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <h1 class="main__title">Mis reservas</h1>
            <div class="main__nav">
                <ul class="nav__list">
                    
                    <li class="nav__item"><a href="/proRest/paginaMisReservas?opcion=espera&idUsuario=<% out.print(idUsuario); %>">En espera</a></li>
                    <li class="nav__item"><a href="/proRest/paginaMisReservas?opcion=confirmada&idUsuario=<% out.print(idUsuario); %>">Confirmadas</a></li>
                    <li class="nav__item"><a href="/proRest/paginaMisReservas?opcion=terminada&idUsuario=<% out.print(idUsuario); %>">Terminadas</a></li>
                    <li class="nav__item"><a href="/proRest/paginaMisReservas?opcion=cancelada&idUsuario=<% out.print(idUsuario); %>">Canceladas</a></li>
                    
                    
                </ul>
            </div>
            <section class="section__container">
                
                    
                <%
                    String titulo = (String) request.getAttribute("titulo");
                    
                    if(titulo != null){
                        out.print(titulo);
                    } else{
                        out.print("<h2 class='section__title'>Reservas</h2>");
                    }
                %>
                <div class="grid__container" id="userGridContainer">
                    
                    <h3 class="grid__title">ID</h3>
                    <h3 class="grid__title">Usuario</h3>
                    <h3 class="grid__title">Fecha</h3>
                    <h3 class="grid__title">Hora</h3>
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
        
        <%
            String modal = (String) request.getAttribute("modal");

            if(modal != null){
                out.print(modal);
            }
        %>        
                
       
        
        <script src="/proRest/js/script.js" type="module"></script>
    </body>
</html>
