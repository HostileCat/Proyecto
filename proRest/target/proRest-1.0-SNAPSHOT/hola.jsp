<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Categorías</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <%@ include file="componentes/header.jsp" %>
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
    <script src="js/script.js"></script>
</body>
</html>
