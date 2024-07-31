/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Reserva> todasLasReservas(){
        String sql = "SELECT id_reserva, id_cliente_fk, fecha_reserva, hora_reserva, estado_reserva, nombre_usuario "
                + "FROM reserva "
                + "INNER JOIN usuario ON id_usuario_fk = id_usuario "
                + "ORDER BY id_reserva DESC";
        
        List<Reserva> reservas = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Reserva reserva = new Reserva();
                
                reserva.setIdReserva(rs.getInt("id_reserva"));
                reserva.setIdCliente(rs.getInt("id_cliente_fk"));
                reserva.setFecha(rs.getDate("fecha_reserva").toLocalDate());
                reserva.setHora(rs.getTime("hora_reserva").toLocalTime());
                reserva.setEstado(rs.getString("estado_reserva"));
                reserva.setNombreCliente(rs.getString("nombre_usuario"));
                
                reservas.add(reserva);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return reservas;
    }
}
