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
        <title>JSP Page</title>
        <link rel="stylesheet" href="/proRest/css/inventario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <section class="main__section">
                <h1 class="section__title">Añadir Plato</h1>
                    <form action="/proRest/administracionPlato?accion=agregarSubmit" method="post" enctype="multipart/form-data" class="section__form section__form--dish">
                        <div class="section__add addDish">
                          <input type="text" placeholder="Nombre" class="add__input" name="nombrePlato" id="nombrePlato" value="" required>
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
                          <input type="text" placeholder="Descripción" class="add__input" name="descripcionPlato" id="descripcionPlato">
                        </div> 

                        <div class="section__add addDish">  
                          <input type="text" placeholder="Precio" class="add__input" name="precioPlato" id="precioPlato">
                        </div> 

                        <div class="section__add addDish">  
                          <input type="file" accept="image/*" class="addDish__img" name="imagenPlato" id="imagenPlato">
                        </div>

                        <button class="section__addButton">Añadir</button>
                      </form>
                
                
                <div class="section__view">
                    <h2 class="view__title">Vista</h2>
                    <div class="view__card">
                      <div class="view__img" id="vistaImg"></div>
                      <h2 class="view__dishName" id="vistaNombre">Nombre del Plato</h2>
                      <p class="view__dishDescription" id="vistaDescripcion">Descripción de ingredientes</p>
                      <h2 class="view__dishCost" id="vistaPrecio">$10.000</h2>
                    </div>
                </div>
              </section>
        </main>

        <script src="/proRest/js/script.js"></script>
        <script src="/proRest/js/showView.js"></script>
    </body>
</html>
