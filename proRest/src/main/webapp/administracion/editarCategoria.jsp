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
        <title>Editar Categoria</title>
        <link rel="stylesheet" href="/proRest/css/inventario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <section class="main__section">

                <h1 class="section__title">Editar Categoria</h1>
                <form action="/proRest/administracionCategoria?accion=editarSubmit" class="section__form section__form--category" id="categoryForm" method="post">
                  <div class="section__add addCategory">
                    <input type="hidden" id="category" name="accion" value="agregar">
                    <%
                        String idCategoria = (String) request.getAttribute("idCategoria");
                        
                        if (idCategoria != null){
                    %>
                    <input type="hidden" id="categoryId" value="<% out.print(idCategoria);} %>" name="idCategoria" >
                    <input type="text" placeholder="Nombre" class="add__input" id="letterInput" name="nombreCategoria" autocomplete="off">
                  </div>
                  <div class="section__add addCategory">
                    <button class="section__addButton" id="submitButton">Editar</button>
                  </div>
                </form>
            </section>
        </main>

        <script src="/proRest/js/script.js" type="module"></script>
        <script src="/proRest/js/categoryValidation.js" type="module"></script>
    </body>
</html>
