/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.List;
import model.Reserva;
import model.ReservaDAO;

/**
 *
 * @author Diego
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               String opcion = "espera";

        
        String titulo = "";
        String fila = "";
        
        ReservaDAO reservaDAO = new ReservaDAO();
        
        List<Reserva> reservas = reservaDAO.todasLasReservas();        
        System.out.println(reservas);
    
        switch (opcion) {
            case "espera":
                titulo = "<h2 class='section__title'>Reservas en espera</h2>";
                for (Reserva reserva : reservas) {
                    System.out.println(reserva.getEstado());
                    if(reserva.getEstado() == 1){
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
            default:
                break;
     
        } 
        
        System.out.println(titulo);
        System.out.println(fila);
        
    }
    
}
