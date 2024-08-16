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
        <title>Administracion Platos</title>
        <link rel="stylesheet" href="/proRest/css/adminCategorias_Platos.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <h1 class="main__title">Administracion de Platos</h1>
            <div class="main__nav">
                <ul class="nav__list">
                    
                    <li class="nav__item"><a href="/proRest/paginaPlatos?opcion=categoria">Categoria</a></li>
                    <li class="nav__item"><a href="/proRest/paginaPlatos?opcion=plato">Plato</a></li>
                    
                    
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
        <script src="/proRest/js/dishConfirm.js" type="module"></script>
    </body>
</html>
