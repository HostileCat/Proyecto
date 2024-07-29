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
 *
 * @author Diego
 */
@WebServlet("/insertarOpcionesUsuario")
public class SetOpcionesUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        String titulo = "";
        String fila = "";
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        List<Usuario> usuarios = usuarioDAO.todosLosUsuarios();

        switch (opcion) {
            case "cliente":
                titulo = "<h2 class='section__title'>Administrar Clientes</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 4){
                        fila +="<p class='grid__item'>"+ usuario.getId() +"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreRol()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ usuario.getNombreUsuario() +"'>" +
                               "<input type='hidden' name='correoUsuario' value='"+ usuario.getCorreoElectronico() +"'>" +
                               "<input type='hidden' name='contrasenaUsuario' value='"+ usuario.getContrasena() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                                "<input type='hidden' name='idEstado' value='"+ usuario.getEstado() +"'>" +
                                "<button type='submit' class='status__button'>" + (usuario.getEstado() == 1? "Habilitado" : "Inhabilitado") + "</button>" +
                               "</form>" +
                               "</div>";
                    }                          
                }
                break;
            case "empleado":
                titulo = "<h2 class='section__title'>Administrar Empleados</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 3){
                        fila +="<p class='grid__item'>"+ usuario.getId() +"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreRol()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ usuario.getNombreUsuario() +"'>" +
                               "<input type='hidden' name='correoUsuario' value='"+ usuario.getCorreoElectronico() +"'>" +
                               "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
                               "</form>" +
                               "</div>";
                    }                          
                }
                break;
            case "administrador":
                titulo = "<h2 class='section__title'>Administrar Administradores</h2>";
                for (Usuario usuario : usuarios) {
                    
                    if(usuario.getRol() == 2){
                        fila +="<p class='grid__item'>"+ usuario.getId() +"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreUsuario()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getCorreoElectronico()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getContrasena()+"</p>" +
                               "<p class='grid__item'>"+ usuario.getNombreRol()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ usuario.getNombreUsuario() +"'>" +
                               "<input type='hidden' name='correoUsuario' value='"+ usuario.getCorreoElectronico() +"'>" +
                               "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idUsuario' value='"+ usuario.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
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
