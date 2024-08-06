<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Carrito de Compras</title>
    <link rel="stylesheet" href="/proRest/css/pedidoPlatos.css"> <!-- Ajusta la ruta según tu estructura -->
</head>
<body>
    
    <%@ include file="../componentes/header.jsp" %>
    
    <main class="main">
        <h1 class="main__title">Selección de Platos</h1>
   
        <div class="list__container">
            <h2>Pedido</h2>
            <div class="list__grid" id="lista">
                  
                <h3 class="grid__title">Plato</h3>
                <h3 class="grid__title">Precio Unitario</h3>
                <h3 class="grid__title">Cantidad</h3>
                <h3 class="grid__title">Detalles</h3>
                <h3 class="grid__title">Total</h3>
            
                <%
                    String fila = (String) request.getAttribute("fila");
                    
                    if(fila != null){
                        out.print(fila);
                    }
                %>
            </div>
            <div class="total__container">
                <%
                    String total = (String) request.getAttribute("total");
                    
                    if(total != null){
                        out.print(total);
                    }
                %>
            </div>
                
        </div>
        
        
        
    </main>
    <script src="/proRest/js/script.js"></script> 
    <script src="/proRest/js/orderList.js" type="module"></script> 
</body>
</html>
