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
 * Clase DAO para gestionar operaciones con la tabla 'reserva' en la base de datos.
 */
public class ReservaDAO {
    private final Connection conexion;
    /**
     * Constructor que inicializa la conexión a la base de datos.
     * Si la conexión es nula, se informa del error en la conexión.
     */
    
    public ReservaDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }
    }
    
    /**
     * Verifica si existe una reserva activa para un cliente específico.
     * @param reserva El objeto Reserva que contiene el ID del cliente.
     * @return true si existe una reserva activa, false en caso contrario.
     */
    public boolean reservaExistente(Reserva reserva) {
        boolean reservaExistente = false;
        String sql = "SELECT COUNT(*) FROM reserva "
                    + "WHERE id_cliente_fk = ? "
                + "AND (id_estadoR_fk = 1 OR id_estadoR_fk = 2)";        
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
    /**
     * Crea una nueva reserva en la base de datos.
     * @param reserva El objeto Reserva con los detalles de la reserva.
     * @return true si la reserva se creó exitosamente, false en caso contrario.
     */
    public boolean hacerReserva(Reserva reserva) {
           
            String sql = "INSERT INTO reserva (id_cliente_fk, fecha_reserva, hora_reserva, id_estadoR_fk) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = conexion.prepareStatement(sql)) { 
                ps.setInt(1, reserva.getIdCliente());
                ps.setDate(2, Date.valueOf(reserva.getFecha()));
                ps.setTime(3, Time.valueOf(reserva.getHora()));
                ps.setInt(4, reserva.getEstado());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }
        
    }
    /**
     * Sugiere una nueva fecha y hora para una reserva existente.
     * @param reserva El objeto Reserva con la nueva fecha y hora sugeridas.
     * @return true si la sugerencia se actualizó exitosamente, false en caso contrario.
     */
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
    /**
     * Confirma una sugerencia de nueva fecha y hora para una reserva.
     * @param reserva El objeto Reserva con el ID de la reserva cuya sugerencia se desea confirmar.
     * @return true si la sugerencia se confirmó exitosamente, false en caso contrario.
     */
    public boolean confirmarSugerencia(Reserva reserva) {
        String sql = "UPDATE reserva SET fecha_reserva = fecha_sugerida, hora_reserva = hora_sugerida, estado_sugerencia = 0, id_estadoR_fk = 2 WHERE id_reserva = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdReserva());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Confirma una reserva existente.
     * @param reserva El objeto Reserva con el ID de la reserva que se desea confirmar.
     * @return true si la reserva se confirmó exitosamente, false en caso contrario.
     */
    public boolean confirmarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET id_estadoR_fk = 2 WHERE id_reserva = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdReserva());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Cancela una reserva existente.
     * @param reserva El objeto Reserva con el ID de la reserva que se desea cancelar.
     * @return true si la reserva se canceló exitosamente, false en caso contrario.
     */
    public boolean cancelarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET id_estadoR_fk = 4, estado_sugerencia = 0 WHERE id_reserva = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdReserva());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Marca una reserva como terminada.
     * @param reserva El objeto Reserva con el ID de la reserva que se desea terminar.
     * @return true si la reserva se marcó como terminada exitosamente, false en caso contrario.
     */
    public boolean terminarReserva(Reserva reserva) {
        String sql = "UPDATE reserva SET id_estadoR_fk = 3 WHERE id_reserva = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdReserva());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Obtiene todas las reservas de la base de datos, incluyendo información del cliente.
     * @return Una lista de objetos Reserva.
     */
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
