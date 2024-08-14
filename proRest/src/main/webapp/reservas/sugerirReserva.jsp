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
        <title>Sugerir Reserva</title>
        <link rel="stylesheet" href="/proRest/css/reservas.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        
       
        
        <main class="main">
            <section class="main__section">

                <h1 class="section__title">Agregar Categoria</h1>
                <form id="section__form" action="/proRest/administracionReservas" class="section__form" method="post">
                  <div class="section__add">
                    <input class="add__input" type="date" id="fechaReserva" name="fechaReserva" required>                  
                  </div>
                  <div class="section__add">
                    <input class="add__input" type="time" id="horaReserva" name="horaReserva" required>                  
                  </div>
                  
                  <%
                      String idReserva = (String) request.getAttribute("idReserva");
                  %>
                  <input type="hidden" id="idReserva" name="idReserva" value="<% out.print(idReserva); %>">                                    
                  <input type="hidden" id="category" name="accion" value="sugerirSubmit">                  
                  <input type="hidden" id="idUsuario" name="idUsuario" value="<% out.print(idUsuario); %>">
                  <button type="button" class="section__addButton">Agregar</button>
                </form>
            </section>
        </main>

        <script src="/proRest/js/date.js" type="module"></script>
    </body>
</html>
