/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.*;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet para la autenticación de usuarios.
 */
@WebServlet("/autenticacionUsuario")
public class AutenticacionUsuario extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        // Usuario iniciando sesión
        if(accion.equalsIgnoreCase("iniciarSesion")){
            // Obtener los parámetros del formulario de inicio de sesión
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");

            Usuario usuario = new Usuario();

            usuario.setCorreoElectronico(correoElectronico);
            usuario.setContrasena(contrasena);
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            if(usuarioDAO.usuarioInhabilitado(usuario)){
                request.setAttribute("errorMessage", "<span id='errorCorreo' class='mensajeError--envio'>El usuario esta inhabilitado.</span>");
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
                
                
            } else{
                boolean accionExitosa = usuarioDAO.autenticarUsuario(usuario);

                if (accionExitosa) {
                    // Usuario autenticado correctamente
                    HttpSession session = request.getSession(); // se inicia una sesion
                    session.setAttribute("usuario", usuario); // se establece el objeto a la sesion


                    response.sendRedirect("main.jsp");



                } else {
                    request.setAttribute("errorMessage", "<span id='errorCorreo' class='mensajeError--envio'>El usuario o la contraseña son incorrectos.</span>");
                    request.getRequestDispatcher("login/login.jsp").forward(request, response);
                } 
            }
            
            
        } 
        // Usuario cerrando sesión
        else if(accion.equalsIgnoreCase("cerrarSesion")){
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalida la sesión del usuario
            }
            response.sendRedirect("index.jsp"); // Redirige a la página de inicio de sesión
        }

        
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        
        // Usuario registrandose
        if(accion.equalsIgnoreCase("registrarse")){
            String nombreUsuario = request.getParameter("nombreUsuario");
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");

            
            Usuario correoUsuario = new Usuario();
            correoUsuario.setCorreoElectronico(correoElectronico);
            UsuarioDAO usuariodao = new UsuarioDAO();
            
            boolean validacion = true;
            
            if (usuariodao.correoRepetido(correoUsuario)) {
                String errorMessage = "<span id='errorCorreo' class='mensajeError--envio'>El correo ya esta registrado.</span>";
                request.setAttribute("errorMessage", errorMessage);
                validacion = false;
            }
            
        

            if (!validacion) {
                request.getRequestDispatcher("login/register.jsp").forward(request, response);
            } else{
                // Crear un objeto Usuario con los datos del formulario
                Usuario usuario = new Usuario();
                usuario.setCorreoElectronico(correoElectronico);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setCorreoElectronico(correoElectronico);
                usuario.setContrasena(contrasena);
                usuario.setRol(4);

                // Insertar el usuario en la base de datos
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean registroExitoso = usuarioDAO.agregarUsuario(usuario);

                // Redireccionar a una página de confirmación o mostrar un mensaje de error
                if (registroExitoso) {
                    response.sendRedirect("login/login.jsp");
                } else {
                    response.sendRedirect("login/register.jsp");
                }
            }
        }
        
        
    }
}
