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
        <title>Administración Reservas</title>
        <link rel="stylesheet" href="/proRest/css/administracionReservas.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <h1 class="main__title">Administracion de Reservas</h1>
            <div class="main__nav">
                <ul class="nav__list">
                    
                    <li class="nav__item"><a href="/proRest/paginaReservas?opcion=espera">En espera</a></li>
                    <li class="nav__item"><a href="/proRest/paginaReservas?opcion=confirmada">Confirmadas</a></li>
                    <li class="nav__item"><a href="/proRest/paginaReservas?opcion=terminada">Terminadas</a></li>
                    <li class="nav__item"><a href="/proRest/paginaReservas?opcion=cancelada">Canceladas</a></li>
                    
                    
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
        
        <div id="confirm" class="confirm">
            <div class="confirm__content">
                <p id="question">¿Estás seguro de que quieres continuar?</p>
                <div class="btn__container">
                    <button id="yesBtn" class="btn btn-yes">Sí</button>
                    <button id="noBtn" class="btn btn-no">No</button>
                </div>
                
            </div>
        </div>
                
       
        
        <script src="/proRest/js/script.js" type="module"></script>
        <script src="/proRest/js/confirmAction.js" type="module"></script>    
    </body>
</html>
