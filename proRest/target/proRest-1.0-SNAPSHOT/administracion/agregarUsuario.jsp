<%-- 
    Document   : administracionUsuarios
    Created on : 18/07/2024, 1:15:56 p. m.
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuarios</title>
        <link rel="stylesheet" href="/proRest/css/administracionUsuario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        
        <main class="register">
            <section class="register__section">
                
                <h2 class="register__title">Agregar Usuario</h2>
                
                <form class="register__form" action="/proRest/administracionUsuario" id="userForm" method="post">

                    <div class="register__group">
                        <input class="register__input register__input--name" type="text" placeholder="Ingresa el nombre" id="letterInput" name="nombreUsuario" autocomplete="off">

                    </div>

                    <div class="register__group">
                        <select class="register__input" id="roleSelect" name="rolUsuario">
                            <option value="">Seleccione el rol de Usuario</option>
                            <%
                                String opciones = (String) request.getAttribute("opciones");

                                if(opciones != null){
                                    out.print(opciones);
                                }
                            %>
                        </select>
                    </div>


                    <!-- Campo para el correo electrónico -->
                    <div class="register__group">
                        <input class="register__input register__input--email" type="text" placeholder="Ingresa el correo electrónico" id="emailInput" name="correoUsuario" autocomplete="off">

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--password" type="password" placeholder="Ingresa la contraseña" id="passwordInput" name="contrasenaUsuario" autocomplete="off">

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--confirmPassword" type="password" placeholder="Confirma la contraseña" id="confirmInput" name="confirmContrasena" autocomplete="off">

                    </div>

                    <!-- Botón para enviar el formulario -->
                    <div class="register__group">
                        <input type="hidden" name="accion" value="agregarSubmit"> 
                        <input type="hidden" name="rol" value="<% out.print(rolUsuario); %>">   
                        
                        <button class="register__button" id="submitButton" type="submit">Agregar</button>
                    </div>
                </form>
            </section>
            
            
        </main>
        
        
        <script src="/proRest/js/script.js" type="module"></script>
        <script src="/proRest/js/userValidation.js" type="module"></script>
    </body>
</html>

