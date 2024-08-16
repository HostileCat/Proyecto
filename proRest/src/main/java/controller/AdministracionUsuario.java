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
import javax.servlet.http.HttpSession;
import model.Rol;
import model.RolDAO;
import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet para la administración de platos.
 */
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
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombreUsuario");
        String correo = request.getParameter("correoUsuario");
        String idUsuarioString = request.getParameter("idUsuario");
        String accion = request.getParameter("accion");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        switch (accion) {
            case "agregarSubmit":
                {
                    String rolUsuario = request.getParameter("rol");
                    String contraseña = request.getParameter("contrasenaUsuario");
                    
                    int idRol = Integer.parseInt(request.getParameter("rolUsuario"));
                    Usuario usuario = new Usuario();
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoElectronico(correo);
                    usuario.setContrasena(contraseña);
                    usuario.setRol(idRol);
                    
                    boolean accionExitosa = usuarioDAO.agregarUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        switch (idRol) {
                            case 2:
                                response.sendRedirect("paginaUsuarios?opcion=administrador&rolUsuario="+ rolUsuario +"");
                                break;
                            case 3:
                                response.sendRedirect("paginaUsuarios?opcion=empleado&rolUsuario="+ rolUsuario +"");
                                break;
                            case 4:
                                response.sendRedirect("paginaUsuarios?opcion=cliente&rolUsuario="+ rolUsuario +"");
                                break;
                            default:
                                
                                break;
                        }
                        
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       break;
                }
            case "editarSubmit": // el administrado edita un usuario
                {
                    String rolUsuario = request.getParameter("rol");
                    // Editar un usuario existente
                    int idUsuario = Integer.parseInt(idUsuarioString);
                    int idRol = Integer.parseInt(request.getParameter("rolUsuario"));
                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoElectronico(correo);
                    usuario.setRol(idRol);
                    boolean accionExitosa = usuarioDAO.actualizarUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        switch (idRol) {
                            case 2:
                                response.sendRedirect("paginaUsuarios?opcion=administrador&rolUsuario="+ rolUsuario +"");
                                break;
                            case 3:
                                response.sendRedirect("paginaUsuarios?opcion=empleado&rolUsuario="+ rolUsuario +"");
                                break;
                            case 4:
                                response.sendRedirect("paginaUsuarios?opcion=cliente&rolUsuario="+ rolUsuario +"");
                                break;
                            default:
                                
                                break;
                        }                    
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       break;
                }
            case "editarPerfil": // el usuario edita su propio perfil
                {
                    // Editar un usuario existente
                    int idUsuario = Integer.parseInt(idUsuarioString);
                    int idRol = Integer.parseInt(request.getParameter("rolUsuario"));
                    String contraseña = request.getParameter("contrasenaUsuario");
                    
                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoElectronico(correo);
                    usuario.setContrasena(contraseña);
                    usuario.setRol(idRol);
                    boolean accionExitosa = usuarioDAO.actualizarPerfil(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        
                        HttpSession session = request.getSession(false);
                        if (session != null) {
                            session.invalidate(); // Invalida la sesión del usuario
                        }
                        response.sendRedirect("login/login.jsp"); // Redirige a la página de inicio de sesión
         
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "estado":
                {
                    int idUsuario = Integer.parseInt(idUsuarioString);
                    
                    List<Usuario> usuarios = usuarioDAO.todosLosUsuarios();
                    
                    int idEstado = 0;
                    int idRol = 0;
            
                    for (Usuario usuario : usuarios){
                        if (usuario.getId() == Integer.parseInt(idUsuarioString)){
                            idEstado = usuario.getEstado();
                            idRol = usuario.getRol();
                        }
                    }
                    
                    if(idEstado == 1){
                        idEstado = 2;
                    } else{
                        idEstado = 1;
                    }
                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);
                    usuario.setEstado(idEstado);
                    boolean accionExitosa = usuarioDAO.cambiarEstadoUsuario(usuario);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        switch (idRol) {
                            case 2:
                                response.sendRedirect("paginaUsuarios?opcion=administrador");
                                break;
                            case 3:
                                response.sendRedirect("paginaUsuarios?opcion=empleado");
                                break;
                            case 4:
                                response.sendRedirect("paginaUsuarios?opcion=cliente");
                                break;
                            default:
                                
                                break;
                        }                    
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
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        
        String opciones = "";
        
        switch (accion) {
            case "agregar":
                {
                    String rolUsuario = request.getParameter("rolUsuario");
                    RolDAO rolDAO = new RolDAO();
                    List<Rol> roles = rolDAO.todosLosRoles();
                    for (Rol rol : roles){
                        
                        if(rol.getIdRol() == 1){
                            continue;
                        }
                        
                        if(rol.getIdRol() == 2 && Integer.parseInt(rolUsuario) >= 2){
                            continue;
                        }
                        
                        opciones += "<option value='"+ rol.getIdRol() +"'>"+ rol.getNombreRol() +"</option>";
                    }       
                    request.setAttribute("rolUsuario", opciones);
                    request.setAttribute("opciones", opciones);
                    request.setAttribute("accion", "agregarSubmit");
                    request.getRequestDispatcher("administracion/agregarUsuario.jsp").forward(request, response);
                    break;
                }
            case "editar": // se insertan los datos en la pagina (administrador)
                {
                    String idRolUsuario = request.getParameter("idRolUsuario");
                    String rolUsuario = request.getParameter("rolUsuario");
                    String idUsuarioString = request.getParameter("idUsuario");
                    String nombre = "";
                    String correo = "";
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    List<Usuario> usuarios = usuarioDAO.todosLosUsuarios();
                    for (Usuario usuario : usuarios){
                        if (usuario.getId() == Integer.parseInt(idUsuarioString)){
                            nombre = usuario.getNombreUsuario();
                            correo = usuario.getCorreoElectronico();
                        }
                    }       
                    
                    RolDAO rolDAO = new RolDAO();
                    List<Rol> roles = rolDAO.todosLosRoles();
                    for (Rol rol : roles){
                        
                        if(rol.getIdRol() == 1){
                            continue;
                        }
                        if(rol.getIdRol() == 2 && Integer.parseInt(rolUsuario) >= 2){
                            continue;
                        }
                        int idRolUsuarioInt = Integer.parseInt(idRolUsuario);
                        opciones += "<option value='"+ rol.getIdRol() +"' "+ (rol.getIdRol() == idRolUsuarioInt? "selected": "") +">"+ rol.getNombreRol() +"</option>";
                    }       
                    request.setAttribute("opciones", opciones);
                    request.setAttribute("accion", "editarSubmit");
                    request.setAttribute("id", idUsuarioString);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("correo", correo);
                    request.setAttribute("idUsuario", idUsuarioString);
                    request.getRequestDispatcher("administracion/editarUsuario.jsp").forward(request, response);
                    break;
                }
            case "perfil": // se insertan los datos en la pagina (cualquier usuario)
                {
                    String idUsuarioString = request.getParameter("idUsuario");
                    String nombre = "";
                    String correo = "";
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    List<Usuario> usuarios = usuarioDAO.todosLosUsuarios();
                    for (Usuario usuario : usuarios){
                        if (usuario.getId() == Integer.parseInt(idUsuarioString)){
                            nombre = usuario.getNombreUsuario();
                            correo = usuario.getCorreoElectronico();
                        }
                    }       
                    request.setAttribute("accion", "editarSubmit");
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("correo", correo);
                    request.setAttribute("idUsuario", idUsuarioString);
                    request.getRequestDispatcher("administracion/editarPerfil.jsp").forward(request, response);
                    break;
                }
            default:
                break;
        }
    }
}
