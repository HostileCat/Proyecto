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
import model.Reserva;
import model.ReservaDAO;

/**
 * Servlet para la insertar según el estado las reservas propias del usuario.
 */
@WebServlet("/paginaMisReservas") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
public class PaginaMisReservas extends HttpServlet {

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
        String opcion = request.getParameter("opcion");
        String idUsuario = request.getParameter("idUsuario");
        String titulo = "";
        String fila = "";
        String modal = "";
        
        ReservaDAO reservaDAO = new ReservaDAO();
        
        List<Reserva> reservas = reservaDAO.todasLasReservas();        
    
    
        switch (opcion) {
            case "espera":
            
                
                titulo = "<h2 class='section__title'>Reservas en Espera</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 1 && reserva.getIdCliente() == Integer.parseInt(idUsuario)){
                        fila += "<p class='grid__item'>" + reserva.getIdReserva() + "</p>" +
                                "<p class='grid__item'>" + reserva.getNombreCliente() + "</p>" +
                                "<p class='grid__item'>" + reserva.getFecha() + "</p>" +
                                "<p class='grid__item'>" + reserva.getHora() + "</p>" +
                                "<div class='grid__item actionButtons'>" +
                                "<form action='/proRest/administracionReservas' id='cancelarReserva' method='post'>" +
                                "<input type='hidden' name='accion' value='cancelarCliente'>" +
                                "<input type='hidden' name='idUsuario' value='"+ idUsuario +"'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<button type='submit' class='delete__button'>Cancelar</button>" +
                                "</form>" +
                                "</div>";
                    }      

                    if (reserva.getSugerir() == 1 && reserva.getIdCliente() == Integer.parseInt(idUsuario)){
                        modal += "<div class='modal'>" +
                                "<div class='modal__container'>" +
                                "<h1 class='modal__title'>Fecha de reserva: "+ reserva.getFecha()+" "+ reserva.getHora() +"</h1>"
                                + "<p>Este horario no está disponible. El administrador sugiere una nueva fecha y hora:</p>" +
                                "<p>Fecha: " + reserva.getNuevaFecha() + "</p>" +
                                "<p>Hora: " + reserva.getNuevaHora() + "</p>"
                                + "<p>¿Desea confirmar la nueva fecha?" +
                                "<div class='form__container'>" +
                                "<form action='/proRest/administracionReservas' method='post'>" +
                                "<input type='hidden' name='accion' value='confirmarCliente'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<input type='hidden' name='idUsuario' value='" + idUsuario + "'>" +
                                "<button type='submit' class='button button--confirm'>Confirmar</button>" +
                                "</form>" +
                                "<form action='/proRest/administracionReservas' id='cancelarReserva' method='post'>" +
                                "<input type='hidden' name='accion' value='cancelarCliente'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<input type='hidden' name='idUsuario' value='" + idUsuario + "'>" +
                                "<button type='submit' class='button button--cancel'>Cancelar reserva</button>" +
                                "</form>" +
                                "</div>" +
                                "</div>" +
                                "</div>";

                    }
                    
                    
                }
                
                
            break;  
            case "confirmada":
                titulo = "<h2 class='section__title'>Reservas Confirmadas</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 2 && reserva.getIdCliente() == Integer.parseInt(idUsuario)){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionReservas' id='cancelarReserva' method='post'>" +
                                "<input type='hidden' name='accion' value='cancelarCliente'>" +
                                "<input type='hidden' name='idUsuario' value='"+ idUsuario +"'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<button type='submit' class='delete__button'>Cancelar</button>" +
                                "</form>" +
                               "</div>";
                    }                            
                }
                break;
            case "terminada":
                titulo = "<h2 class='section__title'>Reservas Terminadas</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 3 && reserva.getIdCliente() == Integer.parseInt(idUsuario)){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<p>Sin acciones</p>"+
                               "</div>";
                    }                            
                }
                break;
            case "cancelada":
                titulo = "<h2 class='section__title'>Reservas Canceladas</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 4 && reserva.getIdCliente() == Integer.parseInt(idUsuario)){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<p>Sin acciones</p>"+
                               "</div>";
                    }                            
                }
                break;                
            default:
                break;
     
        } 
        
        request.setAttribute("titulo", titulo);
        request.setAttribute("fila", fila);
        request.setAttribute("modal", modal);
        request.getRequestDispatcher("reservas/misReservas.jsp").forward(request, response);
   
    }
}
