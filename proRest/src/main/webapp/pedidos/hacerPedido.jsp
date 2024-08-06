<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Carrito de Compras</title>
    <link rel="stylesheet" href="/proRest/css/pedidos.css"> <!-- Ajusta la ruta según tu estructura -->
</head>
<body>
    
    <%@ include file="../componentes/header.jsp" %>
    
    <main class="main">
        <h1 class="main__title">Selección de Platos</h1>
        
        <div class="grid__container">
            <!-- Contenedor de categorías y platos -->
            <div class="category__container">
                <h2>Lista de categorías</h2>
                <%
                    String lista = (String) request.getAttribute("lista");
                    
                    if(lista != null){
                        out.print(lista);
                    }
                
                    String container = (String) request.getAttribute("container");
                    
                    if(container != null){
                        out.print(container);
                    }
                %>
                
                
                
                <!-- Agrega más categorías según tu aplicación -->
            </div>
            
            <!-- Contenedor del carrito de compras -->
            <div class="list__container">
                <h2>Pedido</h2>
                <div class="list__grid" id="lista">
                    
                    <h3 class="grid__title">Plato</h3>
                    <h3 class="grid__title">Precio Unitario</h3>
                    <h3 class="grid__title">Cantidad</h3>
                    <h3 class="grid__title">Detalles</h3>
                    <h3 class="grid__title">Total</h3>
                    <h3 class="grid__title">Accion</h3>
                    
                    
                </div>
                <div class="total__container">
                    <form action="/proRest/administracionPedidos" method="post" id="pedidoForm">
                        <input type="hidden" name="idEmpleado" value="<% out.print(idUsuario); %>">
                        <input type="hidden" name="platos" id="platos-input" required>
                        <input type="hidden" name="total" id="total-input">
                        <input type="hidden" name="accion" value="registrar">
                        <button type="submit" class="submit__button">Enviar</button>
                    </form>
                    <h3 class="total__title">Total del Pedido: $<span id="totalPedido">0</span></h3>
                </div>
                
            </div>
        </div>
        
        <!-- Modal para detalles adicionales -->
        <div id="modal" class="modal">
            <div class="modal-content">
                <span class="closeIcon" id="close">&times;</span>
                <h2 class="modalTitle">Detalles Adicionales</h2>
                <form id="modal-form">
                    <label for="detalles">Detalles:</label>
                    <textarea class="textarea" id="detalles" name="detalles" rows="4"></textarea>
                    <div class="modal-buttons">
                        <button type="button" class="acceptButton" id="aceptar-detalle">Aceptar</button>
                        <button type="button" class="closeButton" id="close">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
                        
    <button id="scrollToTopBtn" class="scrollToTopBtn">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512">
            <path d="M214.6 41.4c-12.5-12.5-32.8-12.5-45.3 0l-160 160c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 141.2 160 448c0 17.7 14.3 32 32 32s32-14.3 32-32l0-306.7L329.4 246.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3l-160-160z"/>
        </svg>
    </button>
    
    <script src="/proRest/js/script.js"></script> 
    <script src="/proRest/js/orderList.js" type="module"></script> 
</body>
</html>
