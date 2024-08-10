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
        <title>Historial de pedido</title>
        <link rel="stylesheet" href="/proRest/css/historialPedidos.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <main class="main">
            <section class="section__container">
                <h2 class='section__title'>Historial de pedidos</h2>
                <div class="grid__container" id="userGridContainer">
                    
                    <h3 class="grid__title">ID</h3>
                    <h3 class="grid__title">Fecha</h3>
                    <h3 class="grid__title">Empleado</h3>
                    <h3 class="grid__title">Total</h3>
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
        
        
                
       
        
        <script src="/proRest/js/script.js"></script>
    </body>
</html>
