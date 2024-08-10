/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
    * Clase DAO para gestionar operaciones con la tabla 'roles' en la base de datos.
    */
public class RolDAO {
    private final Connection conexion;
    /**
     * Constructor que inicializa la conexión a la base de datos.
     * Si la conexión es nula, se informa del error en la conexión.
     */
    public RolDAO() {
        conexion = config.Conexion.getConnection(); // Obtener la conexión a la base de datos
        if (conexion == null) {
            System.err.println("Error al conectar a la base de datos");
        }
    }
     /**
     * Obtiene todos los roles disponibles en la base de datos.
     * @return Una lista de objetos Rol con todos los roles.
     */
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
