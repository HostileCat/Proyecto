package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar operaciones con la tabla 'pedido' y 'pedido_platos' en la base de datos.
 */
public class PedidoDAO {
    private final Connection conexion;
    
    /**
     * Constructor que inicializa la conexión a la base de datos.
     * Si la conexión es nula, se informa del error en la conexión.
     */
    public PedidoDAO() {
        conexion = config.Conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }
    }
    
    /**
     * Guarda un nuevo pedido en la base de datos.
     * Primero se inserta el pedido y luego se insertan los platos asociados en una transacción.
     * @param pedido El objeto Pedido que contiene los detalles del pedido.
     * @return true si el pedido y los platos asociados se guardaron exitosamente, false en caso contrario.
     */
    public boolean guardarPedido(Pedido pedido) {
    String sqlPedido = "INSERT INTO pedido (id_usuario_fk, fecha_pedido, total) VALUES (?, ?, ?)";
    String sqlDetalleHistorial = "INSERT INTO detalle_historial (nombrePlato_detalle, precioPlato_detalle) VALUES (?, ?)";
    String sqlPlato = "INSERT INTO pedido_platos (id_pedido_fk, cantidad, id_plato_fk, detalle, id_detalleHistorial_fk) VALUES (?, ?, ?, ?, ?)";

    try {
        conexion.setAutoCommit(false); // Permite agrupar consultas en una sola transaccion

        try (PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) { // Se asigna la operacion de consulta y se obtiene las claves generadas automaticamente
            psPedido.setInt(1, pedido.getIdEmpleado());
            psPedido.setObject(2, java.sql.Timestamp.valueOf(pedido.getFecha())); // Se convierte la fecha a un formato timestamp
            psPedido.setInt(3, pedido.getTotal());

            psPedido.executeUpdate();

            try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) { // obtener las llaves automaticas generadas
                if (generatedKeys.next()) {
                    int idPedido = generatedKeys.getInt(1);

                    try (PreparedStatement psDetalleHistorial = conexion.prepareStatement(sqlDetalleHistorial, Statement.RETURN_GENERATED_KEYS);
                         PreparedStatement psPlato = conexion.prepareStatement(sqlPlato)) {

                        for (PedidoPlato plato : pedido.getPlatos()) {
                            // Insertar en detalle_historial y obtener el ID generado
                            psDetalleHistorial.setString(1, plato.getNombre());
                            psDetalleHistorial.setInt(2, plato.getPrecio());
                            psDetalleHistorial.executeUpdate();

                            try (ResultSet generatedDetalleKeys = psDetalleHistorial.getGeneratedKeys()) { // obtener las llaves automaticas generadas
                                if (generatedDetalleKeys.next()) {
                                    int idDetalle = generatedDetalleKeys.getInt(1);

                                    // Insertar en pedido_platos
                                    psPlato.setInt(1, idPedido);
                                    psPlato.setInt(2, plato.getCantidad());
                                    psPlato.setInt(3, plato.getId());
                                    psPlato.setString(4, plato.getDetalle());
                                    psPlato.setInt(5, idDetalle);
                                    psPlato.addBatch();
                                } else {
                                    throw new SQLException("No se pudo obtener el ID del detalle del historial.");
                                }
                            }
                        }
                        psPlato.executeBatch();
                    }
                } else {
                    throw new SQLException("No se pudo obtener el ID del pedido.");
                }
            }
        }

        conexion.commit(); // Confirma la trasaccion ejecutando todas las consultas
        return true;
    } catch (SQLException e) {
        try {
            conexion.rollback(); // Revertir transacción en caso de error, impidiendo ejecutar las consultas
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
        return false;
    } finally {
        try {
            conexion.setAutoCommit(true); // Restaurar la trasaccion individual
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
    
    /**
     * Obtiene todos los pedidos de la base de datos.
     * @return Una lista de objetos Pedido.
     */
    public List<Pedido> todosLosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id_pedido, id_usuario_fk, fecha_pedido, total, nombre_usuario " +
                     "FROM pedido " +
                     "INNER JOIN usuario ON id_usuario_fk = id_usuario " +
                     "ORDER BY fecha_pedido DESC";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id_pedido"));
                pedido.setIdEmpleado(rs.getInt("id_usuario_fk"));
                pedido.setFecha(rs.getTimestamp("fecha_pedido").toLocalDateTime());
                pedido.setTotal(rs.getInt("total"));
                pedido.setNombreEmpleado(rs.getString("nombre_usuario"));
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones según tu aplicación
        } 

        return pedidos;
    }
    
    /**
     * Obtiene todos los platos asociados a un pedido específico.
     * @param pedido El objeto Pedido para el cual se desean obtener los platos.
     * @return Una lista de objetos PedidoPlato.
     */
    public List<PedidoPlato> obtenerPlatosPorPedido(Pedido pedido) {
        List<PedidoPlato> platos = new ArrayList<>();
        String sql = "SELECT id_plato_fk, nombrePlato_detalle, precioPlato_detalle, cantidad, detalle "
                + "FROM pedido_platos "
                + "INNER JOIN detalle_historial ON id_detalleHistorial_fk = id_detalle "
                + "WHERE id_pedido_fk = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, pedido.getIdPedido());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PedidoPlato plato = new PedidoPlato();
                    plato.setId(rs.getInt("id_plato_fk"));
                    plato.setNombre(rs.getString("nombrePlato_detalle"));
                    plato.setPrecio(rs.getInt("precioPlato_detalle"));
                    plato.setCantidad(rs.getInt("cantidad"));
                    plato.setDetalle(rs.getString("detalle"));

                    platos.add(plato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return platos;
    }
}
