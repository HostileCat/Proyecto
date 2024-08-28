package model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que representa un pedido.
 */
public class Pedido {
    private int idPedido;
    private int idEmpleado;
    private String nombreEmpleado;
    private LocalDateTime fecha;
    private int total;
    /**
     * Lista de platos incluidos en el pedido
     * El pedido puede tener múltiples platos asociados a él
     */
    private List<PedidoPlato> platos; 

    // Getters y Setters
    /**
     * Obtiene el ID del pedido.
     * @return El ID del pedido.
     */
    public int getIdPedido() {
        return idPedido;
    }
    /**
     * Establece el ID del pedido.
     * @param idPedido El nuevo ID del pedido.
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    /**
     * Obtiene el ID del empleado.
     * @return El ID del empleado.
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }
    /**
     * Establece el ID del empleado.
     * @param idEmpleado El nuevo ID del empleado.
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    /**
     * Obtiene el nombre del empleado.
     * @return El nombre del empleado.
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    /**
     * Establece el nombre del empleado.
     * @param nombreEmpleado El nuevo nombre del empleado.
     */
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    /**
     * Obtiene la fecha y hora en que se realizó el pedido.
     * @return La fecha y hora del pedido.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha y hora en que se realizó el pedido.
     * @param fecha La nueva fecha y hora del pedido.
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene el total del pedido.
     * @return El total del pedido.
     */
    public int getTotal() {
        return total;
    }
    /**
     * Establece el total del pedido.
     * @param total El nuevo total del pedido.
     */
    public void setTotal(int total) {
        this.total = total;
    }
    /**
     * Obtiene la lista de platos incluidos en el pedido.
     * @return La lista de platos del pedido.
     */
    public List<PedidoPlato> getPlatos() {
        return platos;
    }
    /**
     * Establece la lista de platos incluidos en el pedido.
     * @param platos La nueva lista de platos del pedido.
     */
    public void setPlatos(List<PedidoPlato> platos) {
        this.platos = platos;
    }
}



