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
        <title>Editar Perfil</title>
        <link rel="stylesheet" href="/proRest/css/administracionUsuario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <%
            String nombre = (String) request.getAttribute("nombre");
            String correo = (String) request.getAttribute("correo");
        %>
        
        <main class="register">
            <section class="register__section">
            
                <form class="register__form" action="/proRest/administracionUsuario" id="userForm" method="post">

                    <h2 class="register__title">Editar Perfil</h2>



                    <div class="register__group">
                        <input class="register__input register__input--name"
                               value="<%
                                   if(nombre != null){
                                    out.print(nombre);
                                }
                               %>"
                               type="text" placeholder="Ingresa el nombre" id="letterInput" name="nombreUsuario" autocomplete="off">

                    </div>

                    


                    <!-- Campo para el correo electrónico -->
                    <div class="register__group">
                        <input class="register__input register__input--email"
                               value="<%
                                   if(correo != null){
                                    out.print(correo);
                                }
                               %>"
                               type="text" placeholder="Ingresa el correo electrónico" id="emailInput" name="correoUsuario" autocomplete="off">

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--password" type="password" id="passwordInput" placeholder="Ingresa la contraseña" name="contrasenaUsuario" autocomplete="off">

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--confirmPassword" type="password" id="confirmInput" placeholder="Confirma la contraseña" name="confirmContrasena" autocomplete="off">

                    </div>

                    <!-- Botón para enviar el formulario -->
                    <div class="register__group">
                        <input type="hidden" name="accion"value="editarPerfil">                    
                        <input type="hidden" name="idUsuario"value="<%out.print(idUsuario);%>"> 
                        <input type="hidden" name="rolUsuario"value="<%out.print(rolUsuario);%>"> 
                        <button class="register__button" id="submitButton" type="submit">Editar</button>
                    </div>
                </form>
            </section>               
        </main>
        
        
        <script src="/proRest/js/script.js" type="module"></script>
        <script src="/proRest/js/userValidation.js" type="module"></script>
    </body>
</html>

