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
    public void guardarPlato(Platos platos) {
            String sql = "INSERT INTO platos (nombre_plato, id_categoria_fk, descripcion_plato, precio_plato, imagen_plato) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, platos.getNombrePlato());
                ps.setInt(2, platos.getIdCategoria());
                ps.setString(3, platos.getDescripcionPlato());
                ps.setDouble(4, platos.getPrecioPlato());
                ps.setString(5, platos.getImagenPlato());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public List<Platos> todosLosPlatos() {
        List<Platos> platos = new ArrayList<>();
        String sql = "SELECT * FROM platos";

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
                
                // Agregar el plato a la lista
                platos.add(plato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus requerimientos
        }

        return platos;
    }
}
