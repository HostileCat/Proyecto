<%-- 
    Document   : index
    Created on : 15 abr 2024, 13:36:18
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <header class="header">
            <div class="header__navigation">
                <figure class="navigation__logo">
                    <img src="img/logo.png" alt="Descripción de la imagen" width="64" height="64">
                    <figcaption class="logo__name">Bocado Escencial</figcaption>
                </figure>
                <nav class="navigation__navbar">
                    <ul class="navbar__list">
                        <li class="navbar__item">Inicio</li>
                        <li class="navbar__item">Nosotros</li>
                        <li class="navbar__item">Productos</li> 
                        <li class="navbar__item">Contacto</li> 
                    </ul>
                </nav>
            </div>
            <div class="header__actions">
                <a href="login/login.jsp" class="actions__login">Iniciar Sesión</a>
                <a href="login/register.jsp" class="actions__register">Registrarse</a>
            </div>        
        </header>

        
        <main class="main">
            <section class="main__intro">
                <div class="intro__content">
                    <h1 class="intro__title">Bocado Esencial: Donde Cada Sabor Cuenta</h1>
                    <p class="intro__description">Descubre la Esencia de la Gastronomía en Cada Delicioso Bocado</p>
                    <div class="intro__actions">
                        <a href="${pageContext.request.contextPath}/header" class="actions__login">Iniciar Sesión</a>
                        <a href="#" class="actions__register">Registrarse</a>
                    </div>
                </div>
            </section>

        </main>
        <script src="js/script.js"></script>
    </body>
</html>
