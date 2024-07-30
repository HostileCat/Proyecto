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
        <link rel="stylesheet" href="/proRest/css/administracionReservas.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <h1 class="main__title">Administracion de usuarios</h1>
            <div class="main__nav">
                <ul class="nav__list">
                    
                    <li class="nav__item"><a href="/proRest/paginaPlatos?opcion=categoria">Horarios</a></li>
                    <li class="nav__item"><a href="/proRest/paginaPlatos?opcion=plato">Reservas</a></li>
                    
                    
                </ul>
            </div>
            <section class="section__container">
                
                    
                <%
                        String tabla = (String) request.getAttribute("tabla");
                        String grid = (String) request.getAttribute("grid");
                        
                        out.print(grid);
                        if(tabla != null){
                            out.print(tabla);
                            out.print("</div>");
                        }
                %>

            </section>
        </main>
        
        <div class="add__container">
            <%
                        String botonAgregar = (String) request.getAttribute("botonAgregar");
                        
                        
                        if(botonAgregar != null){
                            out.print(botonAgregar);
                            
                        }
            %>      
        </div>
                
       
        
        <script src="/proRest/js/script.js"></script>
    </body>
</html>
