package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data DAO para manejar las operaciones relacionadas con los usuarios en la base de datos.
 */
public class UsuarioDAO {
    private final Connection conexion;
    
    /**
     * Constructor que establece la conexión a la base de datos.
     */
    public UsuarioDAO() {
        conexion = config.Conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }
    }
    /**
     * Agrega un nuevo usuario a la base de datos.
     * @param usuario El objeto Usuario con la información del nuevo usuario.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre_usuario, correo_usuario, contrasena_usuario, id_rol_fk) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getRol());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    
    /**
     * Verifica si un correo electrónico ya está registrado en la base de datos.
     * @param usuario El objeto Usuario con el correo electrónico a verificar.
     * @return true si el correo electrónico ya está registrado, false en caso contrario.
     */
    public boolean correoRepetido(Usuario usuario) {
        boolean correoExistente = false;
        String sql = "SELECT COUNT(*) FROM usuario WHERE correo_usuario = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
             
            ps.setString(1, usuario.getCorreoElectronico());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) { // verifica si resultSet obtubo algun dato y se verifica si dato es mayor a 0
                    correoExistente = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return correoExistente;
    }
    /**
     * Verifica si un usuario está habilitado.
     * @param usuario El objeto Usuario con el correo electrónico para verificar el estado.
     * @return true si el usuario está habilitado (estado 1), false en caso contrario.
     */
    public boolean usuarioInhabilitado(Usuario usuario) {
        
        String sql = "SELECT id_estado_fk FROM usuario WHERE correo_usuario = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
             
            ps.setString(1, usuario.getCorreoElectronico());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int estado = rs.getInt("id_estado_fk");
                    if (estado == 2){ // verifica si el usuario esta inhabilitado
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
     * Autentica a un usuario comparando su correo electrónico y contraseña.
     * @param usuario El objeto Usuario con las credenciales a verificar.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean autenticarUsuario(Usuario usuario) {
        String sql = "SELECT id_usuario, nombre_usuario, id_rol_fk FROM usuario "
                + "WHERE correo_usuario = ? AND contrasena_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getCorreoElectronico());
            ps.setString(2, usuario.getContrasena());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                    usuario.setRol(rs.getInt("id_rol_fk"));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return false; 
    }
    /**
     * Obtiene una lista de todos los usuarios de la base de datos.
     * @return Una lista de objetos Usuario con la información de todos los usuarios.
     */
    public List<Usuario> todosLosUsuarios(){
        String sql = "SELECT id_usuario, nombre_usuario, correo_usuario, contrasena_usuario, id_rol_fk, nombre_rol, id_estado_fk "
                + "FROM usuario "
                + "INNER JOIN roles ON id_rol_fk = id_rol "
                + "ORDER BY id_usuario DESC";
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idUsuario = rs.getInt("id_usuario");
                String nombreUsuario = rs.getString("nombre_usuario");
                String correoUsuario = rs.getString("correo_usuario");
                String contrasenaUsuario = rs.getString("contrasena_usuario");
                int idRol = rs.getInt("id_rol_fk");
                String nombreRol = rs.getString("nombre_rol");
                int idEstado = rs.getInt("id_estado_fk");
                
                Usuario usuario = new Usuario();
                
                usuario.setId(idUsuario);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setCorreoElectronico(correoUsuario);
                usuario.setContrasena(contrasenaUsuario);
                usuario.setRol(idRol);
                usuario.setNombreRol(nombreRol);
                usuario.setEstado(idEstado);
                
                usuarios.add(usuario);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
        return usuarios;
    }
    /**
     * Actualiza la información de un usuario en la base de datos.
     * @param usuario El objeto Usuario con la nueva información.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre_usuario = ?, correo_usuario = ?, id_rol_fk = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setInt(3, usuario.getRol());
            ps.setInt(4, usuario.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    /**
     * Actualiza la información de un usuario en la base de datos.
     * @param usuario El objeto Usuario con la nueva información.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarPerfil(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre_usuario = ?, correo_usuario = ?, contrasena_usuario = ?, id_rol_fk = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getRol());
            ps.setInt(5, usuario.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    /**
     * Cambia el estado de un usuario en la base de datos.
     * @param usuario El objeto Usuario con el nuevo estado y el ID del usuario.
     * @return true si la actualización del estado fue exitosa, false en caso contrario.
     */
    public boolean cambiarEstadoUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET id_estado_fk = ? WHERE id_usuario = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuario.getEstado());
            ps.setInt(2, usuario.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
}
        
        
    
    
    


