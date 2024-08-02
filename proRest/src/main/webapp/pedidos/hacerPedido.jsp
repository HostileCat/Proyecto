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
        
        <div class="grid-container">
            <!-- Contenedor de categorías y platos -->
            <div class="categorias-container">
                <h2>Categorías</h2>
                <ul class="categorias-list">
                    <li><a href="#categoria1">Categoría 1</a></li>
                    <li><a href="#categoria2">Categoría 2</a></li>
                    <!-- Agrega más categorías según tu aplicación -->
                </ul>
                
                <!-- Categoría 1 -->
                <div class="categoria" id="categoria1">
                    <h3>Categoría 1</h3>
                    <div class="grid">
                        <h3 class="grid__title">Plato</h3>
                        <h3 class="grid__title">Precio</h3>
                        <h3 class="grid__title">Accion</h3>
                        
                        <p class="grid__item">Plato 1</p>
                        <p class="grid__item">$10</p>
                        <button class="agregar__plato" data-plato="Plato 1" data-precio="10">Agregar</button>
                        
                        <div class="grid__item">Plato 2</div>
                        <div class="grid__item">$12</div>
                        <button class="agregar__plato" data-plato="Plato 2" data-precio="12">Agregar</button>
                        
                        <!-- Agrega más platos según tu aplicación -->
                    </div>
                </div>
                
                <!-- Categoría 2 -->
                <div class="categoria" id="categoria2">
                    <h3>Categoría 2</h3>
                    <div class="grid">
                        <h3 class="grid__title">Plato</h3>
                        <h3 class="grid__title">Precio</h3>
                        <h3 class="grid__title">Accion</h3>
                        
                        <p class="grid__item">Plato 3</p>
                        <p class="grid__item">$15</p>
                        <button class="agregar__plato" data-plato="Plato 1" data-precio="10">Agregar</button>
                        <!-- Agrega más platos según tu aplicación -->
                    </div>
                </div>
                
                <!-- Agrega más categorías según tu aplicación -->
            </div>
            
            <!-- Contenedor del carrito de compras -->
            <div class="list__container">
                <h2>Carrito de Compras</h2>
                <div class="list__grid" id="lista">
                    
                    <h3 class="grid__title">Plato</h3>
                    <h3 class="grid__title">Precio Unitario</h3>
                    <h3 class="grid__title">Cantidad</h3>
                    <h3 class="grid__title">Detalles</h3>
                    <h3 class="grid__title">Total</h3>
                    <h3 class="grid__title">Accion</h3>
                    
                    <p class="grid__item">Plato 1fasdfasdfasdfasdasdasdasdasdasdsafasf</p>
                    <p class="grid__item">$10000</p>
                    <input class="grid__item grid__item-number" type="text" name="cantidadPlato" value="1">
                    <button class="detalle__plato" id="detalles">Detalle</button>
                    <p class="grid__item">$100000</p>
                    <button class="remover__plato" data-plato="Plato 1" data-precio="10">Remover</button>
                </div>
            </div>
        </div>
        
        <!-- Modal para detalles adicionales -->
        <div id="modal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Detalles Adicionales</h2>
                <form id="modal-form">
                    <label for="detalles">Detalles:</label>
                    <textarea id="detalles" name="detalles" rows="4"></textarea>
                    <div class="modal-buttons">
                        <button type="button" id="aceptar-detalle">Aceptar</button>
                        <button type="button" class="close">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    
    <script src="/proRest/js/script.js"></script> 
    <script src="/proRest/js/orderList.js"></script> 
</body>
</html>
