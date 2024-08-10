<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalle de pedido</title>
    <link rel="stylesheet" href="/proRest/css/pedidoPlatos.css"> 
</head>
<body>
    
    <%@ include file="../componentes/header.jsp" %>
    
    <main class="main">       
        <div class="list__container" id="listContainer">
            
                <div class="invoice__header">
                  <figure class="navigation__logo">
                    <img src="/proRest/img/logo.png" alt="Descripción de la imagen">
                    <figcaption class="logo__name">Bocado Escencial</figcaption>
                  </figure>

                </div>
            
            <%
                    String info = (String) request.getAttribute("info");
                    
                    if(info != null){
                        out.print(info);
                    }
                %>
            <h1 class="main__title">Pedido</h1>
            
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
        
        <button type="button" class="invoiceButton" id="invoiceButton">Imprimir Factura</button>
                
    </main>
            
    <script src="/proRest/js/script.js"></script> 
    <script src="/proRest/js/orderList.js" type="module"></script> 
    <script src="/proRest/js/invoice.js"></script> 
</body>
</html>
