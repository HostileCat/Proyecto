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
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

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
        if(accion.equalsIgnoreCase("iniciarSesion")){
            // Obtener los parámetros del formulario de inicio de sesión
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");

            // Implementar la lógica de autenticación
            Usuario usuario = new Usuario();

            usuario.setCorreoElectronico(correoElectronico);
            usuario.setContrasena(contrasena);
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            boolean accionExitosa = usuarioDAO.autenticarUsuario(usuario);

            if (accionExitosa) {
                // Usuario autenticado correctamente
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);


                response.sendRedirect("main.jsp");



            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            }
        } else if(accion.equalsIgnoreCase("cerrarSesion")){
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalida la sesión del usuario
            }
            response.sendRedirect("index.jsp"); // Redirige a la página de inicio de sesión
        }

        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        request.setCharacterEncoding("UTF-8");
        
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("registrarse")){
            String nombreUsuario = request.getParameter("nombreUsuario");
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");
            String confirmContrasena = request.getParameter("confirmContrasena");

            // Patrón para validar el nombre (solo letras)
            String namePattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
            // Patrón para validar el correo electrónico
            String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            // Patrón para validar la contraseña
            String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";

            String errorMessage = null;


            if (!Pattern.matches(namePattern, nombreUsuario)) {
                errorMessage = "El nombre solo puede contener letras y espacios.";
            } else if (!Pattern.matches(emailPattern, correoElectronico)) {
                errorMessage = "El correo electrónico no es válido.";
            } else if (!Pattern.matches(passwordPattern, contrasena)) {
                errorMessage = "La contraseña debe tener al menos 6 caracteres, incluyendo una mayúscula, una minúscula y un número.";
            } else if (!contrasena.equals(confirmContrasena)) {
                errorMessage = "Las contraseñas no coinciden.";
            } else {
                Usuario usuario = new Usuario();
                usuario.setCorreoElectronico(correoElectronico);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.correoRepetido(usuario)) {
                    errorMessage = "El correo electrónico ya está registrado.";
                }
            }

            if (errorMessage != null) {
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("login/register.jsp").forward(request, response);
            } else{
                // Crear un objeto Usuario con los datos del formulario
                Usuario usuario = new Usuario();
                usuario.setCorreoElectronico(correoElectronico);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setCorreoElectronico(correoElectronico);
                usuario.setContrasena(contrasena);

                // Insertar el usuario en la base de datos
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                boolean registroExitoso = usuarioDAO.registrarCliente(usuario);

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
