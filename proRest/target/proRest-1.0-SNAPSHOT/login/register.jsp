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
        <title>Registrarse</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    </head>
    <body>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            String errorNombre = (String) request.getAttribute("errorNombre");
            String errorCorreo = (String) request.getAttribute("errorCorreo");
            String errorContrasena = (String) request.getAttribute("errorContrasena");
            String errorConfirmContrasena = (String) request.getAttribute("errorConfirmContrasena");
            
            
        %>
        <main class="register">
            
            <section class="register__section">
                <form class="register__form" action="${pageContext.request.contextPath}/autenticacionUsuario" method="post">
                    <img src="${pageContext.request.contextPath}/img/logoHigh.png" alt="Descripción de la imagen" class="logo">
                    <h2 class="register__title">Registrate</h2>



                    <div class="register__group">
                        <input class="register__input register__input--name" type="text" placeholder="Ingresa tu nombre" name="nombreUsuario">
                        <%
                            if(errorNombre != null){
                                out.print("<span class='registerError'>"+ errorNombre +"</span>");
                            }
                        %>
                    </div>

                    <!-- Campo para el correo electrónico -->
                    <div class="register__group">
                        <input class="register__input register__input--email" type="text" placeholder="Ingresa tu correo electrónico" name="correoElectronico">
                        <%
                            if(errorCorreo != null){
                                out.print("<span class='registerError'>"+ errorCorreo +"</span>");
                            }
                            if(errorMessage != null){
                                out.print("<span class='registerError'>"+ errorMessage +"</span>");
                            }
                        %>
                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--password" type="password" placeholder="Ingresa tu contraseña" name="contrasena">
                        <%
                            if(errorContrasena != null){
                                out.print("<span class='registerError'>"+ errorContrasena +"</span>");
                            }
                        %>
                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--confirmPassword" type="password" placeholder="Confirma tu contraseña" name="confirmContrasena">
                        <%
                            if(errorConfirmContrasena != null){
                                out.print("<span class='registerError'>"+ errorConfirmContrasena +"</span>");
                            }
                        %>
                    </div>

                    <!-- Botón para enviar el formulario -->
                    <div class="register__group">
                        <input type="hidden" name="accion" value="registrarse">                    
                        <button class="register__button" type="submit">Registrarse</button>
                    </div>
                </form>
            </section> 
        </main>
    </body>
</html>
