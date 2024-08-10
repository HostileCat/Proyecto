/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reserva;
import model.ReservaDAO;

/**
 * Servlet para la administración de reservas.
 */
@WebServlet("/administracionReservas")
public class AdministracionReservas extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
       String idUsuario = request.getParameter("idUsuario");
       
       

       String accion = request.getParameter("accion");
       
        switch (accion) {
            case "agregarSubmit":
                {
                    String fechaReservaString = request.getParameter("fechaReserva");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // se crea el formato para la fecha
                    LocalDate fechaReserva = LocalDate.parse(fechaReservaString, formatter); // se parsea la fecha segun el formato

                    String horaReservaString = request.getParameter("horaReserva");      
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm"); // se crea el formato para la hora  
                    LocalTime horaReserva = LocalTime.parse(horaReservaString, timeFormatter); // se parsea la hora segun el formato
                    
                    String estadoReserva = "1";

                    Reserva reserva = new Reserva();
                    reserva.setIdCliente(Integer.parseInt(idUsuario));
                    reserva.setFecha(fechaReserva);
                    reserva.setHora(horaReserva);
                    reserva.setEstado(Integer.parseInt(estadoReserva));
                    
                      
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    
                    boolean accionExitosa = reservaDAO.hacerReserva(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaMisReservas?opcion=espera&idUsuario="+ idUsuario);
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    
                    
                    
                    break;
                }
            case "sugerirSubmit":
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    String nuevaFechaString = request.getParameter("fechaReserva");
                    DateTimeFormatter newDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // se crea el formato para la fecha
                    LocalDate nuevaFecha = LocalDate.parse(nuevaFechaString, newDateFormatter); // se parsea la fecha segun el formato

                    String nuevaHoraString = request.getParameter("horaReserva");       
                    DateTimeFormatter NewtimeFormatter = DateTimeFormatter.ofPattern("HH:mm"); // se crea el formato para la hora  
                    LocalTime nuevaHora = LocalTime.parse(nuevaHoraString, NewtimeFormatter); // se parsea la hora segun el formato
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    reserva.setNuevaFecha(nuevaFecha);
                    reserva.setNuevaHora(nuevaHora);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.sugerirNuevaFechaHora(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaReservas?opcion=espera");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }      
                    break;
                }
            case "confirmarCliente": // el cliente confirma la fecha sugerida
                
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.confirmarSugerencia(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaMisReservas?opcion=confirmada&idUsuario="+ idUsuario +"");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }
                    
                    break;
                }
            case "confirmar": // el administrador confirma la reserva
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.confirmarReserva(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaReservas?opcion=confirmada");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }
                    
                    break;
                }   
                
            case "cancelarCliente": // el cliente cancela la fecha sugerida
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.cancelarReserva(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaMisReservas?opcion=cancelada&idUsuario="+ idUsuario +"");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }
                    
                    break;
                }
            case "cancelar": // el administrador cancela la reserva
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.cancelarReserva(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaReservas?opcion=cancelada");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }
                    
                    break;
                }
            case "terminar": 
                {
                    int idReserva = Integer.parseInt(request.getParameter("idReserva"));
                    
                    Reserva reserva = new Reserva();
                    reserva.setIdReserva(idReserva);
                    
                    ReservaDAO reservaDAO = new ReservaDAO();
                    
                    boolean accionExitosa = reservaDAO.terminarReserva(reserva);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaReservas?opcion=terminada");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }
                    
                    break;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
       String idReserva = request.getParameter("idReserva");
       
       if ("sugerir".equals(accion)){
           request.setAttribute("idReserva", idReserva);
           request.getRequestDispatcher("reservas/sugerirReserva.jsp").forward(request, response);
       }
    }

}
