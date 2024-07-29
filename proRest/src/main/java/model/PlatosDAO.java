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


public class PlatosDAO {
    private final Connection conexion;
    
    public PlatosDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
            // Aquí puedes lanzar una excepción o manejar el error de alguna otra manera
        }
        
        
    }
    public boolean guardarPlato(Platos platos) {
            String sql = "INSERT INTO platos (nombre_plato, id_categoria_fk, descripcion_plato, precio_plato, imagen_plato) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, platos.getNombrePlato());
                ps.setInt(2, platos.getIdCategoria());
                ps.setString(3, platos.getDescripcionPlato());
                ps.setDouble(4, platos.getPrecioPlato());
                ps.setString(5, platos.getImagenPlato());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
    }
    
    public List<Platos> todosLosPlatos() {
        List<Platos> platos = new ArrayList<>();
        String sql = "SELECT id_plato, nombre_plato, descripcion_plato, precio_plato, id_categoria_fk, imagen_plato, nombre_categoria FROM platos INNER JOIN categoria ON id_categoria_fk = id_categoria "
                + "ORDER BY id_plato DESC";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Platos plato = new Platos();
                plato.setId(rs.getInt("id_plato"));
                plato.setNombrePlato(rs.getString("nombre_plato"));
                plato.setDescripcionPlato(rs.getString("descripcion_plato"));
                plato.setPrecioPlato(rs.getInt("precio_plato"));
                plato.setIdCategoria(rs.getInt("id_categoria_fk")); // Ajustar según tu esquema de base de datos
                plato.setImagenPlato(rs.getString("imagen_plato"));
                plato.setNombreCategoria(rs.getString("nombre_categoria"));
                
                // Agregar el plato a la lista
                platos.add(plato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return platos;
    }
    
    public boolean actualizarPlato(Platos plato) {
        String sql = "UPDATE platos SET nombre_plato = ?, categoria_plato = ?, descripcion_plato = ?, precio_plato = ?, imagen_plato = ? WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, plato.getNombrePlato());
            ps.setInt(2, plato.getIdCategoria());
            ps.setString(3, plato.getDescripcionPlato());
            ps.setDouble(4, plato.getPrecioPlato());
            ps.setString(5, plato.getImagenPlato());
            ps.setInt(6, plato.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarPlato(Platos plato) {
        String sql = "DELETE FROM platos WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, plato.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
