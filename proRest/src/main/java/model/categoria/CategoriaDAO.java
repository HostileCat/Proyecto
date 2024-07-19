/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Propietario
 */
public class CategoriaDAO {
    private final Connection conexion;
    
    public CategoriaDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
            // Aquí puedes lanzar una excepción o manejar el error de alguna otra manera
        }
    }
    
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
    
    public List<Categoria> todasLasCategorias() {
        String sql = "SELECT id_categoria, nombre_categoria FROM categoria";
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
    
    public boolean eliminarCategoria(Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, categoria.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    
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

    
