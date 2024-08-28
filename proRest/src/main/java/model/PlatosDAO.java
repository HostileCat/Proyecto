package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para gestionar operaciones con la tabla 'platos' en la base de datos.
 */
public class PlatosDAO {
    private final Connection conexion;
    
    /**
     * Constructor que inicializa la conexión a la base de datos.
     * Si la conexión es nula, se informa del error en la conexión.
     */
    public PlatosDAO() {
        conexion = config.Conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }

    }
    /**
     * Guarda un nuevo plato en la base de datos.
     * @param platos El objeto Platos que contiene los detalles del plato.
     * @return true si el plato se guardó exitosamente, false en caso contrario.
     */
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
    /**
     * Obtiene todos los platos de la base de datos, incluyendo información de la categoría.
     * @return Una lista de objetos Platos.
     */
    public List<Platos> todosLosPlatos() {
        List<Platos> platos = new ArrayList<>();
        String sql = "SELECT id_plato, nombre_plato, descripcion_plato, precio_plato, id_categoria_fk, imagen_plato, estado, nombre_categoria "
                + "FROM platos "
                + "INNER JOIN categoria ON id_categoria_fk = id_categoria "
                + "ORDER BY id_plato DESC";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Platos plato = new Platos();
                plato.setId(rs.getInt("id_plato"));
                plato.setNombrePlato(rs.getString("nombre_plato"));
                plato.setDescripcionPlato(rs.getString("descripcion_plato"));
                plato.setPrecioPlato(rs.getInt("precio_plato"));
                plato.setIdCategoria(rs.getInt("id_categoria_fk")); 
                plato.setImagenPlato(rs.getString("imagen_plato"));
                plato.setEstado(rs.getBoolean("estado"));
                plato.setNombreCategoria(rs.getString("nombre_categoria"));
                
                // Agregar el plato a la lista
                platos.add(plato);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return platos;
    }
    /**
     * Obtiene todos los platos habilitados (estado = 1) de la base de datos, ordenados por categoría.
     * @return Una lista de objetos Platos.
     */
    public List<Platos> obtenerPlatosPorCategoria() {
        String sql = "SELECT id_plato, nombre_plato, descripcion_plato, precio_plato, id_categoria_fk, imagen_plato "
                + "FROM platos WHERE estado = 1 "
                + "ORDER BY id_categoria_fk;";
        
        List<Platos> platos = new ArrayList<>();
        
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
        } 

        return platos;
    }
    /**
     * Verifica si un plato está habilitado.
     * @param plato El objeto Platos cuyo estado se desea verificar.
     * @return true si se encontró el plato, false en caso contrario.
     */
    public boolean platoHabilitado(Platos plato) {
        
        String sql = "SELECT estado FROM platos WHERE id_plato = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
             
            ps.setInt(1, plato.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int estado = rs.getInt("id_estado_fk");
                    if (estado == 1){
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return false;
    }
    /**
     * Actualiza los detalles de un plato existente en la base de datos.
     * @param plato El objeto Platos con los nuevos detalles del plato.
     * @return true si el plato se actualizó exitosamente, false en caso contrario.
     */
    public boolean actualizarPlato(Platos plato) {
        String sql = "UPDATE platos SET nombre_plato = ?, id_categoria_fk = ?, descripcion_plato = ?, precio_plato = ?, imagen_plato = ? WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, plato.getNombrePlato());
            ps.setInt(2, plato.getIdCategoria());
            ps.setString(3, plato.getDescripcionPlato());
            ps.setInt(4, plato.getPrecioPlato());
            ps.setString(5, plato.getImagenPlato());
            ps.setInt(6, plato.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    /**
     * Cambia el estado de un plato (habilitado o inhabilitado).
     * @param plato El objeto Platos con el nuevo estado.
     * @return true si el estado se actualizó exitosamente, false en caso contrario.
     */
    public boolean cambiarEstadoPlato(Platos plato) {
        String sql = "UPDATE platos SET estado = ? WHERE id_plato = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setBoolean(1, plato.isEstado());
            ps.setInt(2, plato.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
}
