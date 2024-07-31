/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author Diego
 */
public class ReservaDAO {
    private final Connection conexion;
    
    public ReservaDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
            // Aquí puedes lanzar una excepción o manejar el error de alguna otra manera
        }
    }
    
    public boolean hacerReserva(Reserva reserva) {
            String sql = "INSERT INTO reserva (id_cliente_fk, fecha_reserva, hora_reserva, estado_reserva) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1, reserva.getIdCliente());
                ps.setDate(2, Date.valueOf(reserva.getFecha()));
                ps.setTime(3, Time.valueOf(reserva.getHora()));
                ps.setString(4, reserva.getEstado());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
    }
}
