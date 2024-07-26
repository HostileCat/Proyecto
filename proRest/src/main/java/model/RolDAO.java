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

/**
 *
 * @author Diego
 */
public class RolDAO {
    private final Connection conexion;

    public RolDAO() {
        conexion = config.conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
            // Aquí puedes lanzar una excepción o manejar el error de alguna otra manera
        }
    }
    
    public List<Rol> todosLosRoles(){
        String sql = "SELECT * FROM roles";
        
        
        List<Rol> roles = new ArrayList<>();
        
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idRol = rs.getInt("id_rol");
                String nombreRol = rs.getString("nombre_Rol");
                
                Rol rol = new Rol();
                rol.setIdRol(idRol);
                rol.setNombreRol(nombreRol);
                
                
                roles.add(rol);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return roles;
    }
}
