<%-- 
    Document   : login
    Created on : 15 abr 2024, 16:08:42
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <main class="login">
            <form class="login__form" action="${pageContext.request.contextPath}/autenticacionUsuario" method="get">
                <img src="${pageContext.request.contextPath}/img/logoHigh.png" alt="Descripción de la imagen" class="logo">
                <h2 class="login__title">Inicia Sesión</h2> 
                
                <%
                    String error = (String) request.getAttribute("errorMessage");
                    if(error != null){
                        out.print("<p>"+ error +"</p>");
                    }
                %>


                <!-- Campo para el correo electrónico -->
                <div class="login__group">
                    <input class="login__input login__input--email" type="email" placeholder="Ingresa tu correo electrónico" name="correoElectronico">
                </div>

                <!-- Campo para la contraseña -->
                <div class="login__group">
                    <input class="login__input login__input--password" type="password" placeholder="Ingresa tu contraseña" name="contrasena">
                </div>

                <a href="forgotPassword.jsp" class="login__goForgotPassword">¿Olvitaste tu contraseña?</a>

                <!-- Botón para enviar el formulario -->
                <div class="login__group">
                    <input type="hidden" name="accion" value="iniciarSesion">
                    <button class="login__button" type="submit">Iniciar Sesión</button>
                </div>
                <p class="login__registerText">¿No tienes cuenta? Regístrate</p>
                <!-- Enlace para registrarse -->
                <div class="login__group">
                    <a class="login__goRegister" href="${pageContext.request.contextPath}/login/register.jsp">Registrarse</a>
                </div>
            </form>
        </main>
    </body>
</html>
