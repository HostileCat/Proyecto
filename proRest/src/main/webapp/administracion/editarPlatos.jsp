<%-- 
    Document   : administracionUsuarios
    Created on : 18/07/2024, 1:15:56 p. m.
    Author     : Propietario
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Platos</title>
        <link rel="stylesheet" href="/proRest/css/inventario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <section class="main__section">
                <h1 class="section__title">Editar Plato</h1>
                    <form action="/proRest/administracionPlato?accion=editarSubmit" method="post" enctype="multipart/form-data" class="section__form section__form--dish">
                        
                        <%
                            String idPlato = (String) request.getAttribute("idPlato");
                            String descripcionPlato = (String) request.getAttribute("descripcionPlato");
                            String precioPlato = (String) request.getAttribute("precioPlato");
                            String imagenPlato = (String) request.getAttribute("imagenPlato");
                            String nombrePlato = (String) request.getAttribute("nombrePlato");
                        %>
                        
                        <div class="section__add addDish">
                            <input type="text" placeholder="Nombre" class="add__input" name="nombrePlato" id="nombrePlato" value="<% out.print(nombrePlato); %>" required>
                        </div> 

                        <div class="section__add addDish">
                          <select class="add__input" id="category" name="categoriaPlato" required>
                                    <option value="">Seleccione una categoría</option>
                                    <% 
                                        String opciones = (String) request.getAttribute("opciones");

                                        out.print(opciones);
                                    %>
                          </select>
                        </div>  

                        <div class="section__add addDish">
                          <input type="text" placeholder="Descripción" class="add__input" name="descripcionPlato" value="<% out.print(descripcionPlato); %>" id="descripcionPlato" required>
                        </div> 

                        <div class="section__add addDish">  
                          <input type="text" placeholder="Precio" class="add__input" name="precioPlato" value="<% out.print(precioPlato); %>" id="precioPlato" required>
                        </div> 

                        <div class="section__add addDish">  
                          <input type="file" accept="image/*" class="addDish__img" name="imagenPlato" id="imagenPlato" required>
                        </div>
                        
                          <input type="hidden" name="idPlato" value="<% out.print(idPlato); %>">
                        <button class="section__addButton">Editar</button>
                      </form>
                
                
                <div class="section__view">
                    <h2 class="view__title">Vista</h2>
                    <div class="view__card">
                      <div class="view__img" id="vistaImg" style="background-image: url('/proRest/uploads/<% out.print(imagenPlato); %>')"></div>
                      <h2 class="view__dishName" id="vistaNombre"><% out.print(nombrePlato); %></h2>
                      <p class="view__dishDescription" id="vistaDescripcion"><% out.print(descripcionPlato); %></p>
                      <h2 class="view__dishCost" id="vistaPrecio">$<% out.print(precioPlato); %></h2>
                    </div>
                </div>
              </section>
        </main>

        <script src="/proRest/js/script.js"></script>
        <script src="/proRest/js/showView.js"></script>
    </body>
</html>
