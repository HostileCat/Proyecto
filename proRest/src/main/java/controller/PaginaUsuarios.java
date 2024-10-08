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
import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet para la insertar usuarios segun el rol.
 */
@WebServlet("/paginaUsuarios") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
public class PaginaUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String opcion = request.getParameter("opcion");
        String rolUsuario = request.getParameter("rolUsuario");
        
        String titulo = "";
        String fila = "";
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<Usuario> usuarios = usuarioDAO.todosLosUsuarios();

        switch (opcion) {
            case "cliente":
                titulo = "<h2 class='section__title'>Administrar Clientes</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 4){
                        fila +="<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ (usuario.getEstado() == 1? "Habilitado" : "Inhabilitado")+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='rolUsuario' value='"+ rolUsuario +"'>" +
                               "<input type='hidden' name='idRolUsuario' value='"+ usuario.getRol() +"'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>"
                                + "<input type='hidden' name='idEstado' value='"+ (usuario.getEstado() == 1? "2" : "1") +"'>" +
                                "<button type='submit' class='status__button "+ (usuario.getEstado() == 2? "negative" : "") +"'>" + (usuario.getEstado() == 1? "Inhabilitar" : "Habilitar") + "</button>" +
                               "</form>" +
                               "</div>";
                    }                          
                }
                break;
            case "empleado":
                titulo = "<h2 class='section__title'>Administrar Empleados</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 3){
                        fila +="<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ (usuario.getEstado() == 1? "Habilitado" : "Inhabilitado")+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                                "<input type='hidden' name='rolUsuario' value='"+ rolUsuario +"'>" +
                                "<input type='hidden' name='idRolUsuario' value='"+ usuario.getRol() +"'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<button type='submit' class='status__button "+ (usuario.getEstado() == 2? "negative" : "") +"'>" + (usuario.getEstado() == 1? "Inhabilitar" : "Habilitar") + "</button>" +
                               "</form>" +
                               "</div>";
                    }                          
                }
                break;
            case "administrador":
                titulo = "<h2 class='section__title'>Administrar Administradores</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 2){
                        fila +="<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ (usuario.getEstado() == 1? "Habilitado" : "Inhabilitado")+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                                "<input type='hidden' name='rolUsuario' value='"+ rolUsuario +"'>" +
                                "<input type='hidden' name='idRolUsuario' value='"+ usuario.getRol() +"'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<button type='submit' class='status__button "+ (usuario.getEstado() == 2? "negative" : "") +"'>" + (usuario.getEstado() == 1? "Inhabilitar" : "Habilitar") + "</button>" +
                               "</form>" +
                               "</div>";
                               
                    }                          
                }
                break;
            default:
                break;
        }

        request.setAttribute("titulo", titulo);
        request.setAttribute("fila", fila);
        request.getRequestDispatcher("administracion/administracionUsuarios.jsp").forward(request, response);
    }
    
}
