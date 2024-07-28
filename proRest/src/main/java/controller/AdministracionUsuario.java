/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rol;
import model.RolDAO;
import model.Usuario;
import model.UsuarioDAO;


@WebServlet("/administracionUsuario")
public class AdministracionUsuario extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreUsuario");
        String correo = request.getParameter("correoUsuario");
        String contraseña = request.getParameter("contrasenaUsuario");
        String idUsuarioString = request.getParameter("idUsuario");
        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregarSubmit":
                {
                    // Agregar un nuevo usuario
                    
                    int idRolFk = Integer.parseInt(request.getParameter("rolUsuario"));
                    Usuario usuario = new Usuario();
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoElectronico(correo);
                    usuario.setContrasena(contraseña);
                    usuario.setRol(idRolFk);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    boolean accionExitosa = usuarioDAO.agregarUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("administracion/administracionUsuarios.jsp");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       break;
                }
            case "editarSubmit":
                {
                    // Editar un usuario existente
                    int idUsuario = Integer.parseInt(idUsuarioString);
                    int idRolFk = Integer.parseInt(request.getParameter("rolUsuario"));
                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoElectronico(correo);
                    usuario.setContrasena(contraseña);
                    usuario.setRol(idRolFk);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    boolean accionExitosa = usuarioDAO.actualizarUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("administracion/administracionUsuarios.jsp");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       break;
                }
            case "eliminar":
                {
                    int idUsuario = Integer.parseInt(idUsuarioString);
                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    boolean accionExitosa = usuarioDAO.eliminarUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("administracion/administracionUsuarios.jsp");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       break;
                }
            default:
                break;
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
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        String opciones = "";
        
        if(accion.equals("agregar")){
            
            
            RolDAO rolDAO = new RolDAO();
            
            List<Rol> roles = rolDAO.todosLosRoles();
            
            for (Rol rol : roles){
                
                if(rol.getIdRol() == 1){
                    continue;
                }
                
                opciones += "<option value='"+ rol.getIdRol() +"'>"+ rol.getNombreRol() +"</option>";
            }
            
            request.setAttribute("opciones", opciones);
            request.setAttribute("accion", "agregarSubmit");
            request.getRequestDispatcher("administracion/agregarUsuario.jsp").forward(request, response);
        } else if(accion.equals("editar")){
            String nombre = request.getParameter("nombreUsuario");
            String correo = request.getParameter("correoUsuario");
            String idUsuarioString = request.getParameter("idUsuario");
            
            RolDAO rolDAO = new RolDAO();
            
            List<Rol> roles = rolDAO.todosLosRoles();
            
            for (Rol rol : roles){
                
                if(rol.getIdRol() == 1){
                    continue;
                }
                
                opciones += "<option value='"+ rol.getIdRol() +"'>"+ rol.getNombreRol() +"</option>";
            }
            
            request.setAttribute("opciones", opciones);
            request.setAttribute("accion", "editarSubmit");
            request.setAttribute("nombre", nombre);
            request.setAttribute("correo", correo);
            request.setAttribute("idUsuario", idUsuarioString);
            request.getRequestDispatcher("administracion/agregarUsuario.jsp").forward(request, response);
        }
    }
}
