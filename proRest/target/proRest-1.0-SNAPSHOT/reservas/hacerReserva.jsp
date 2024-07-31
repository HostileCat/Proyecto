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
        <link rel="stylesheet" href="/proRest/css/reservas.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        
       
        
        <main class="main">
            <section class="main__section">

                <h1 class="section__title">Agregar Categoria</h1>
                <form id="section__form" action="/proRest/administracionReservas" class="section__form" method="post">
                  <div class="section__add">
                      <input type="hidden" id="idUsuario" name="idUsuario" value="<% out.print(idUsuario); %>">
                      <input class="add__input" type="text" id="nombreUsuario" name="nombreUsuario" value="<% out.print(nombreUsuario); %>" disabled>
                  </div>
                  <div class="section__add">
                    <input class="add__input" type="date" id="fechaReserva" name="fechaReserva" required>                  
                  </div>
                  <div class="section__add">
                    <input class="add__input" type="time" id="horaReserva" name="horaReserva" required>                  
                  </div>
                  <input type="hidden" id="category" name="accion" value="agregarSubmit">
                  <button type="button" class="section__addButton">Agregar</button>
                </form>
            </section>
        </main>

        <script src="/proRest/js/date.js"></script>
    </body>
</html>
