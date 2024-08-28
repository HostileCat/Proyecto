/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar operaciones con la tabla 'categoria' en la base de datos.
 */
public class CategoriaDAO {
    private final Connection conexion;
    /**
     * Constructor que inicializa la conexión a la base de datos.
     * Si la conexión es nula, se informa del error en la conexión.
     */
    public CategoriaDAO() {
        conexion = config.Conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }
    }
    /**
     * Agrega una nueva categoría a la base de datos.
     * @param categoria El objeto Categoria que contiene los detalles de la nueva categoría.
     * @return true si la categoría se agregó exitosamente, false en caso contrario.
     */
    public boolean agregarCategoria(Categoria categoria){
        String sql = "INSERT INTO categoria (nombre_categoria) VALUES (?)";
        
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    /**
     * Obtiene todas las categorías de la base de datos, excluyendo la categoría con ID 1.
     * @return Una lista de objetos Categoria.
     */
    public List<Categoria> todasLasCategorias() {
        String sql = "SELECT id_categoria, nombre_categoria FROM categoria WHERE id_categoria <> 1 "
                + "ORDER BY id_categoria DESC";
        List<Categoria> categorias = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                
                Categoria categoria = new Categoria();
                categoria.setId(idCategoria);
                categoria.setNombreCategoria(nombreCategoria);
                categorias.add(categoria);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return categorias;
    }
    /**
     * Obtiene las categorías que están relacionadas con al menos un plato.
     * @return Una lista de objetos Categoria.
     */
    public List<Categoria> obtenerCategoriasRelacionadas() {
        String sql = "SELECT DISTINCT id_categoria, nombre_categoria "
                + "FROM categoria "
                + "INNER JOIN platos ON id_categoria = id_categoria_fk "
                + "WHERE id_categoria <> 1;";
        List<Categoria> categorias = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCategoria = rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria");
                
                Categoria categoria = new Categoria();
                categoria.setId(idCategoria);
                categoria.setNombreCategoria(nombreCategoria);
                categorias.add(categoria);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return categorias;
    }
    
    
    /**
     * Elimina una categoría de la base de datos. Primero actualiza los platos asociados para que apunten a una categoría predeterminada (ID 1).
     * @param categoria El objeto Categoria que contiene la información de la categoría a eliminar.
     * @return true si la categoría se eliminó exitosamente, false en caso contrario.
     */
    public boolean eliminarCategoria(Categoria categoria) {
        String sqlUpdate = "UPDATE platos SET id_categoria_fk = 1 WHERE id_categoria_fk = ?";
        String sqlDelete = "DELETE FROM categoria WHERE id_categoria = ?";
        
        try (PreparedStatement psUpdate = conexion.prepareStatement(sqlUpdate);
             PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
            psUpdate.setInt(1, categoria.getId());
            psUpdate.executeUpdate();

            // Elimina la categoría cuando se actualicen las filas correspondientes
            
            psDelete.setInt(1, categoria.getId());
            int filasBorradas = psDelete.executeUpdate();
            return filasBorradas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    /**
     * Actualiza el nombre de una categoría existente en la base de datos.
     * @param categoria El objeto Categoria que contiene el nuevo nombre y el ID de la categoría a actualizar.
     * @return true si el nombre de la categoría se actualizó exitosamente, false en caso contrario.
     */
    public boolean actualizarNombreCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre_categoria = ? WHERE id_categoria = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setInt(2, categoria.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
   }
}

    
