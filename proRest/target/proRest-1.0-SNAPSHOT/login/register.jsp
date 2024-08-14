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
        <link rel="stylesheet" href="/proRest/css/register.css">
    </head>

        <main class="register">
            
            <section class="register__section">
                <form class="register__form" id="registerForm" action="/proRest/autenticacionUsuario" method="post" novalidate>
                    <img src="/proRest/img/logoHigh.png" alt="Descripción de la imagen" class="logo">
                    <h2 class="register__title">Registrate</h2>

                    <%
                        String errorMessage = (String) request.getAttribute("errorMessage");
                    
                        if(errorMessage != null){
                            out.print(errorMessage);
                        }
                    %>

                    <div class="register__group">
                        <input class="register__input register__input--name" type="text" placeholder="Ingresa tu nombre" id="letterInput" name="nombreUsuario" autocomplete="off">
                        
                    </div>

                    <!-- Campo para el correo electrónico -->
                    <div class="register__group">
                        <input class="register__input register__input--email" type="text" placeholder="Ingresa tu correo electrónico" id="emailInput" name="correoElectronico" autocomplete="off">
                        
                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--password" type="password" placeholder="Ingresa tu contraseña" id="passwordInput" name="contrasena" autocomplete="off">
                        
                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--confirmPassword" type="password" placeholder="Confirma tu contraseña" id="confirmInput" name="confirmContrasena" autocomplete="off">
                        
                    </div>
                   
                    <!-- Botón para enviar el formulario -->
                    <div class="register__group">
                        <input type="hidden" name="accion" value="registrarse">                    
                        <button class="register__button" id="submitButton" type="submit">Registrarse</button>
                    </div>
                </form>
            </section> 
        </main>
        
        <script src="/proRest/js/registerValidation.js" type="module"></script>
    </body>
</html>
