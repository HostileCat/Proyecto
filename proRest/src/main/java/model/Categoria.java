/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Clase que representa una categoría de platos.
 */
public class Categoria {
    private int id;
    private String nombreCategoria;
   
    /**
     * Obtiene el ID de la categoría.
     * @return El ID de la categoría.
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el ID de la categoría.
     * @param id El nuevo ID de la categoría.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    /**
     * Establece el nombre de la categoría.
     * @param nombreCategoria El nuevo nombre de la categoría.
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

}
