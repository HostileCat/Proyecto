package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Rol;

public class UsuarioDAO {
    private final Connection conexion;

    public UsuarioDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
            // Aquí puedes lanzar una excepción o manejar el error de alguna otra manera
        }
    }

    public boolean registrarCliente(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre_usuario, correo_usuario, contrasena_usuario, id_rol_fk) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, 4);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para verificar si un correo electrónico ya está registrado
    public boolean correoRepetido(Usuario usuario) {
        boolean correoExistente = false;
        String sql = "SELECT COUNT(*) FROM usuario WHERE correo_usuario = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
             
            ps.setString(1, usuario.getCorreoElectronico());
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    correoExistente = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return correoExistente;
    }

    public boolean autenticarUsuario(Usuario usuario) {
        String sql = "SELECT nombre_usuario, id_rol_fk FROM usuario WHERE correo_usuario = ? AND contrasena_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getCorreoElectronico());
            ps.setString(2, usuario.getContrasena());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                    usuario.setRol(rs.getInt("id_rol_fk"));
                    return true; // Usuario encontrado y autenticado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Usuario no encontrado o error de SQL
    }
    
    public List<Usuario> todosLosUsuarios(){
        String sql = "SELECT id_usuario, nombre_usuario, correo_usuario, contrasena_usuario, id_rol_fk, nombre_rol FROM usuario INNER JOIN roles ON id_rol_fk = id_rol";
        
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
                
                Usuario usuario = new Usuario();
                Rol rol = new Rol();
                usuario.setId(idUsuario);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setCorreoElectronico(correoUsuario);
                usuario.setContrasena(contrasenaUsuario);
                usuario.setRol(idRol);
                usuario.setNombreRol(nombreRol);
                
                usuarios.add(usuario);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }
}
        
        
    
    
    


