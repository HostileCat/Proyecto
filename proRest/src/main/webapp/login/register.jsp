<%-- 
    Document   : register
    Created on : 22 abr 2024, 14:26:56
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    </head>
    <body>
        <%
            String error = (String) request.getAttribute("errorMessage");
            
        %>
        <main class="register">
            <form class="register__form" action="${pageContext.request.contextPath}/autenticacionUsuario" method="post">
                <img src="${pageContext.request.contextPath}/img/logoHigh.png" alt="Descripción de la imagen" class="logo">
                <h2 class="register__title">Registrate</h2>

                <%
                    if(error != null){
                        out.print("<p>"+ error +"</p>");
                    }
                %>
                
                <div class="register__group">
                    <input class="register__input register__input--name" type="text" placeholder="Ingresa tu nombre" name="nombreUsuario">
                </div>

                <!-- Campo para el correo electrónico -->
                <div class="register__group">
                    <input class="register__input register__input--email" type="text" placeholder="Ingresa tu correo electrónico" name="correoElectronico">
                </div>

                <!-- Campo para la contraseña -->
                <div class="register__group">
                    <input class="register__input register__input--password" type="password" placeholder="Ingresa tu contraseña" name="contrasena">
                </div>

                <!-- Campo para la contraseña -->
                <div class="register__group">
                    <input class="register__input register__input--confirmPassword" type="password" placeholder="Confirma tu contraseña" name="confirmContrasena">
                </div>

                <!-- Botón para enviar el formulario -->
                <div class="register__group">
                    <input type="hidden" name="accion" value="registrarse">                    
                    <button class="register__button" type="submit">Registrarse</button>
                </div>
            </form>
        </main>
    </body>
</html>
