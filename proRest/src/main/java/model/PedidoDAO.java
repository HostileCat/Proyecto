package model;

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
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
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
        String sqlPlato = "INSERT INTO pedido_platos (id_plato_fk, nombre, cantidad, detalle, precio, id_pedido_fk) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conexion.setAutoCommit(false); // Iniciar transacción

            try (PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                psPedido.setInt(1, pedido.getIdEmpleado());
                psPedido.setObject(2, java.sql.Timestamp.valueOf(pedido.getFecha()));
                psPedido.setInt(3, pedido.getTotal());

                psPedido.executeUpdate();

                try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPedido = generatedKeys.getInt(1);

                        try (PreparedStatement psPlato = conexion.prepareStatement(sqlPlato)) {
                            for (PedidoPlato plato : pedido.getPlatos()) {
                                psPlato.setInt(1, plato.getId());
                                psPlato.setString(2, plato.getNombre());
                                psPlato.setInt(3, plato.getCantidad());
                                psPlato.setString(4, plato.getDetalle());
                                psPlato.setInt(5, plato.getPrecio());
                                psPlato.setInt(6, idPedido);
                                psPlato.addBatch();
                            }
                            psPlato.executeBatch();
                        }
                    } else {
                        throw new SQLException("No se pudo obtener el ID del pedido.");
                    }
                }
            }

            conexion.commit(); // Confirmar transacción
            return true;
        } catch (SQLException e) {
            try {
                conexion.rollback(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.setAutoCommit(true); // Restaurar auto-commit
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
                     "JOIN usuario ON id_usuario_fk = id_usuario " +
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
        String sql = "SELECT id_plato_fk, nombre, precio, cantidad, detalle " +
                     "FROM pedido_platos " +
                     "WHERE id_pedido_fk = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, pedido.getIdPedido());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PedidoPlato plato = new PedidoPlato();
                    plato.setId(rs.getInt("id_plato_fk"));
                    plato.setNombre(rs.getString("nombre"));
                    plato.setPrecio(rs.getInt("precio"));
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
