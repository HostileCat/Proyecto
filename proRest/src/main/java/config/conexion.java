/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Clase para gestionar la conexión a la base de datos MySQL.
 * 
 * 
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/pro_rest";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    /**
     * Obtiene una conexión a la base de datos.
     * @return Objeto Connection que representa la conexión establecida.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establece la conexión utilizando URL, usuario y contraseña
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    
}


