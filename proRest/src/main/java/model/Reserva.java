package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que representa una reserva.
 */
public class Reserva {
    private int idReserva;
    private int idCliente;
    private LocalDate fecha;
    private LocalTime hora;
    private int estado;
    private String nombreCliente;
    private LocalDate nuevaFecha;
    private LocalTime nuevaHora;
    private int sugerir; 

    /**
     * Obtiene el ID de la reserva.
     * @return El ID de la reserva.
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el ID de la reserva.
     * @param idReserva El nuevo ID de la reserva.
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene el ID del cliente que realizó la reserva.
     * @return El ID del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente que realizó la reserva.
     * @param idCliente El nuevo ID del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene la fecha de la reserva.
     * @return La fecha de la reserva.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reserva.
     * @param fecha La nueva fecha de la reserva.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la reserva.
     * @return La hora de la reserva.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la reserva.
     * @param hora La nueva hora de la reserva.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el estado actual de la reserva.
     * @return El estado de la reserva.
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la reserva.
     * @param estado El nuevo estado de la reserva.
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el nombre del cliente que realizó la reserva.
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente que realizó la reserva.
     * @param nombreCliente El nuevo nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene la nueva fecha sugerida para la reserva.
     * @return La nueva fecha sugerida.
     */
    public LocalDate getNuevaFecha() {
        return nuevaFecha;
    }

    /**
     * Establece la nueva fecha sugerida para la reserva.
     * @param nuevaFecha La nueva fecha sugerida.
     */
    public void setNuevaFecha(LocalDate nuevaFecha) {
        this.nuevaFecha = nuevaFecha;
    }

    /**
     * Obtiene la nueva hora sugerida para la reserva.
     * @return La nueva hora sugerida.
     */
    public LocalTime getNuevaHora() {
        return nuevaHora;
    }

    /**
     * Establece la nueva hora sugerida para la reserva.
     * @param nuevaHora La nueva hora sugerida.
     */
    public void setNuevaHora(LocalTime nuevaHora) {
        this.nuevaHora = nuevaHora;
    }

    /**
     * Obtiene el indicador de sugerencia para la reserva.
     * @return El indicador de sugerencia.
     */
    public int getSugerir() {
        return sugerir;
    }

    /**
     * Establece el indicador de sugerencia para la reserva.
     * @param sugerir El nuevo indicador de sugerencia.
     */
    public void setSugerir(int sugerir) {
        this.sugerir = sugerir;
    }
}
