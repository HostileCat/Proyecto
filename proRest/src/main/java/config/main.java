/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.SQLException;


public class main {

    public static void main(String[] args) {
        try {
            Connection connection = conexion.getConnection();
            if (connection != null) {
                System.out.println("Conexión exitosa");
                connection.close();
            } else {
                System.out.println("Error al conectar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}