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
 *
 * @author Propietario
 */
@WebServlet("/paginaReservas")
public class PaginaReservas extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
        String titulo = "";
        String fila = "";
        
        ReservaDAO reservaDAO = new ReservaDAO();
        
        List<Reserva> reservas = reservaDAO.todasLasReservas();        
    
    
        switch (opcion) {
            case "espera":
                titulo = "<h2 class='section__title'>Reservas en espera</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 1){
                        fila += "<p class='grid__item'>" + reserva.getIdReserva() + "</p>" +
                                "<p class='grid__item'>" + reserva.getNombreCliente() + "</p>" +
                                "<p class='grid__item'>" + reserva.getFecha() + "</p>" +
                                "<p class='grid__item'>" + reserva.getHora() + "</p>" +
                                "<div class='grid__item actionButtons'>" +
                                "<form action='/proRest/administracionReservas' method='post'>" +
                                "<input type='hidden' name='accion' value='confirmar'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<button type='submit' class='confirm__button'>Confirmar</button>" +
                                "</form>" +
                                "<form action='/proRest/administracionReservas' method='get'>" +
                                "<input type='hidden' name='accion' value='sugerir'>" +
                                "<input type='hidden' name='idReserva' value='" + reserva.getIdReserva() + "'>" +
                                "<button type='submit' class='edit__button'>Sugerir</button>" +
                                "</form>" +
                                "</div>";
                    }                          
                }
                break;
            case "confirmada":
                titulo = "<h2 class='section__title'>Administrar Empleados</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 2){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>"
                                + "<input type='hidden' name='idEstado' value=''>" +
                                "<button type='submit' class='status__button'></button>" +
                               "</form>" +
                               "</div>";
                    }                            
                }
                break;
            case "terminada":
                titulo = "<h2 class='section__title'>Administrar Administradores</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 3){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>"
                                + "<input type='hidden' name='idEstado' value=''>" +
                                "<button type='submit' class='status__button'></button>" +
                               "</form>" +
                               "</div>";
                    }                            
                }
                break;
            case "cancelada":
                titulo = "<h2 class='section__title'>Administrar Administradores</h2>";
                for (Reserva reserva : reservas) {
                    
                    if(reserva.getEstado() == 3){
                        fila +="<p class='grid__item'>"+ reserva.getIdReserva()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getNombreCliente()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getFecha()+"</p>" +
                               "<p class='grid__item'>"+ reserva.getHora()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionUsuario' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionUsuario' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idUsuario' value='"+ reserva.getIdReserva() +"'>"
                                + "<input type='hidden' name='idEstado' value=''>" +
                                "<button type='submit' class='status__button'></button>" +
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
        request.getRequestDispatcher("reservas/administracionReservas.jsp").forward(request, response);
   
    }
}
