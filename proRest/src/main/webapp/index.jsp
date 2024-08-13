<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
    
    if (session != null && session.getAttribute("usuario") != null) {
        response.sendRedirect("/proRest/main.jsp"); // Redirigir a la página principal si la sesión está iniciada
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bocado Escencial</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <%@ include file="componentes/headerUnlogged.jsp" %>
        

        
        <main class="main">
            <section class="main__intro">
                <div class="intro__content">
                    <h1 class="intro__title">Bocado Esencial: Donde Cada Sabor Cuenta</h1>
                    <p class="intro__description">Descubre la Esencia de la Gastronomía en Cada Delicioso Bocado</p>
                    <div class="intro__actions">
                        <a href="/proRest/paginaCarta" class="actions__login">Ver Carta</a>
                    </div>
                </div>
            </section>

        </main>
        <script src="js/script.js" type="module"></script>
    </body>
</html>
