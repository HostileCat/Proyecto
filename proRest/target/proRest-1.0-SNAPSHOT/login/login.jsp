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
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    </head>
    <body>
        <main class="login">
            <section class="login__section">
                <form class="login__form" action="${pageContext.request.contextPath}/autenticacionUsuario" method="get">
                    <img src="${pageContext.request.contextPath}/img/logoHigh.png" alt="Descripción de la imagen" class="logo">
                    <h2 class="login__title">Inicia Sesión</h2> 

                    <%
                        String error = (String) request.getAttribute("errorMessage");
                        if(error != null){
                            out.print("<span class='loginError'>"+ error +"</span>");
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

                    <div class="login__group">
                        <input type="hidden" name="accion" value="iniciarSesion">
                        <button class="login__button" type="submit">Iniciar Sesión</button>
                    </div>
                    <p class="login__registerText">¿No tienes cuenta? Regístrate</p>
                    <!-- Enlace para registrarse -->
                    <div class="login__group">
                        <a class="login__goRegister" href="/proRest/login/register.jsp">Registrarse</a>
                    </div>
                </form>
            </section>
        </main>
    </body>
</html>
