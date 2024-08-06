/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * Clase que representa un plato incluido en un pedido.
 */
public class PedidoPlato {
    private int id;
    private String nombre;
    private int cantidad;
    private String detalle;
    private int precio;

    // Getters y Setters
    /**
     * Obtiene el ID del plato.
     * @return El ID del plato.
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el ID del plato.
     * @param id El nuevo ID del plato.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre del plato.
     * @return El nombre del plato.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del plato.
     * @param nombre El nuevo nombre del plato.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la cantidad del plato.
     * @return La cantidad del plato.
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Establece la cantidad del plato.
     * @param cantidad La nueva cantidad del plato.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el detalle adicional del plato en el pedido.
     * @return El detalle del plato.
     */
    public String getDetalle() {
        return detalle;
    }
    /**
     * Establece el detalle adicional del plato en el pedido.
     * @param detalle El nuevo detalle del plato.
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    /**
     * Obtiene el precio del plato.
     * @return El precio del plato.
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * Establece el precio del plato.
     * @param precio El nuevo precio del plato.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
