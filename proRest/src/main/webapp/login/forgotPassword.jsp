<%-- 
    Document   : forgotPassword
    Created on : 22 abr 2024, 14:57:42
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/forgotPassword.css">
    </head>
    <body>
        <main class="forgotPassword">
        <form class="forgotPassword__form" action="#">
            <h2 class="forgotPassword__title">Recupera tu contraseña</h2>
            
            <!-- Campo para el correo electrónico -->
            <div class="forgotPassword__group">
                <input class="forgotPassword__input forgotPassword__input--email" type="email" placeholder="Ingresa tu correo electrónico">
            </div>
    
            <!-- Botón para enviar el formulario -->
            <div class="forgotPassword__group">
                <button class="forgotPassword__button" type="submit">Enviar código de verificación</button>
            </div>
        </form>
    </main>
    </body>
</html>
