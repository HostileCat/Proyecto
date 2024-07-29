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
        <link rel="stylesheet" href="/proRest/css/inventario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <section class="main__section">

                <h1 class="section__title">Editar Categoria</h1>
                <form action="/proRest/administracionCategoria?accion=editarSubmit" class="section__form section__form--category" method="post">
                  <div class="section__add addCategory">
                    <input type="hidden" id="category" name="accion" value="agregar">
                    <%
                        String idCategoria = (String) request.getAttribute("idCategoria");
                        
                        if (idCategoria != null){
                    %>
                    <input type="hidden" id="categoryId" value="<% out.print(idCategoria);} %>" name="idCategoria">
                    <input type="text" placeholder="Nombre" class="add__input" name="nombreCategoria">
                  </div>
                  <button class="section__addButton">Editar</button>
                </form>
            </section>
        </main>

        <script src="/proRest/js/script.js"></script>
    </body>
</html>
