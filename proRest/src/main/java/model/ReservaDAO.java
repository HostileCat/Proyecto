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
    
    public boolean reservaEnEsperaExistente(Reserva reserva) {
        boolean reservaExistente = false;
        String sql = "SELECT COUNT(*) FROM reserva "
                    + "WHERE id_cliente_fk = ? AND id_estadoR_fk = 1;";        
        try (PreparedStatement ps = conexion.prepareStatement(sql)){           
            ps.setInt(1, reserva.getIdCliente());            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    reservaExistente = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reservaExistente;
    }
    
    public boolean hacerReserva(Reserva reserva) {
           
            String sql = "INSERT INTO reserva (id_cliente_fk, fecha_reserva, hora_reserva, id_estadoR_fk) VALUES (?, ?, ?, ?)";

            try (PreparedStatement psInsert = conexion.prepareStatement(sql)) { 
                psInsert.setInt(1, reserva.getIdCliente());
                psInsert.setDate(2, Date.valueOf(reserva.getFecha()));
                psInsert.setTime(3, Time.valueOf(reserva.getHora()));
                psInsert.setInt(4, reserva.getEstado());
                
                int filasAfectadas = psInsert.executeUpdate();
                
                return filasAfectadas > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
        
    }
    
    public boolean sugerirNuevaFechaHora(Reserva reserva) {
    String sql = "UPDATE reserva SET fecha_sugerida = ?, hora_sugerida = ?, estado_sugerencia = 1 WHERE id_reserva = ?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setDate(1, Date.valueOf(reserva.getNuevaFecha()));
        ps.setTime(2, Time.valueOf(reserva.getNuevaHora()));
        ps.setInt(3, reserva.getIdReserva());
        
        int filasAfectadas = ps.executeUpdate();
        
        return filasAfectadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public List<Reserva> todasLasReservas(){
        String sql = "SELECT id_reserva, id_cliente_fk, fecha_reserva, hora_reserva, id_estadoR_fk, hora_sugerida, fecha_sugerida, estado_sugerencia, nombre_usuario "
                + "FROM reserva "
                + "INNER JOIN usuario ON id_cliente_fk = id_usuario "
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
                reserva.setEstado(rs.getInt("id_estadoR_fk"));
                reserva.setNombreCliente(rs.getString("nombre_usuario"));
                
                reserva.setNuevaFecha(rs.getDate("fecha_sugerida").toLocalDate());
                reserva.setNuevaHora(rs.getTime("hora_sugerida").toLocalTime());
                reserva.setSugerir(rs.getInt("estado_sugerencia"));
                
                reservas.add(reserva);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return reservas;
    }
}
