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
        <title>Editar Usuario</title>
        <link rel="stylesheet" href="/proRest/css/administracionUsuario.css">        
    </head>
    <body>
        <%@ include file="../componentes/header.jsp" %>
        
        <%
            String id = (String) request.getAttribute("id");
            String nombre = (String) request.getAttribute("nombre");
            String correo = (String) request.getAttribute("correo");
        %>
        
        <main class="register">
            <section class="register__section">
            
                <form class="register__form" action="/proRest/administracionUsuario" method="post">

                    <h2 class="register__title">Editar Usuario </h2>



                    <div class="register__group">
                        <input class="register__input register__input--name"
                               value="<%
                                   if(nombre != null){
                                    out.print(nombre);
                                }
                               %>"
                               type="text" placeholder="Ingresa el nombre" name="nombreUsuario" required>

                    </div>

                    <div class="register__group">
                        <select class="register__input" id="rol" name="rolUsuario" required>
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
                        <input class="register__input register__input--email"
                               value="<%
                                   if(correo != null){
                                    out.print(correo);
                                }
                               %>"
                               type="text" placeholder="Ingresa el correo electrónico" name="correoUsuario" required>

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--password" type="password" placeholder="Ingresa la contraseña" name="contrasenaUsuario" required>

                    </div>

                    <!-- Campo para la contraseña -->
                    <div class="register__group">
                        <input class="register__input register__input--confirmPassword" type="password" placeholder="Confirma la contraseña" name="confirmContrasena" required>

                    </div>

                    <!-- Botón para enviar el formulario -->
                    <div class="register__group">
                        <input type="hidden" name="accion"value="editarSubmit">         
                        <input type="hidden" name="rol" value="<% out.print(rolUsuario); %>"> 
                        <input type="hidden" name="idUsuario"value="<%out.print(id);%>"> 
                        <button class="register__button" type="submit">Editar</button>
                    </div>
                </form>
            </section>               
        </main>
        
        
        <script src="/proRest/js/script.js"></script>
    </body>
</html>

