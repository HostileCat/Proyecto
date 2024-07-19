/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller.platosServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.platos.Platos;

public class MainTest {

    public static void main(String[] args) {
        // Datos de prueba que simulan los datos recibidos del formulario
        String nombrePlato = "Plato de Prueba";
        int categoriaPlato = 1; // Asegúrate de que esta categoría exista en tu base de datos
        String descripcionPlato = "Esta es una descripción de prueba";
        double precioPlato = 15;
        

        // Simulación de la lógica del servlet para procesar estos datos
        try {
            // Simulación de guardar la imagen en una ruta en el servidor
            

            // Crear el objeto Plato (modelo)
            Platos plato = new Platos();
            plato.setNombrePlato(nombrePlato);
            plato.setIdCategoria(categoriaPlato);
            plato.setDescripcionPlato(descripcionPlato);
            plato.setPrecioPlato((int) precioPlato);
            

            // Guardar los datos en la base de datos simulando la lógica de la DAO
            guardarPlatoEnBaseDeDatos(plato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para simular la copia de un archivo de imagen
    private static void copyFile(File source, File destination) throws IOException {
        try (InputStream in = source.toURI().toURL().openStream();
             FileOutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    // Método para guardar el objeto Plato en la base de datos
    private static void guardarPlatoEnBaseDeDatos(Platos plato) {
        String url = "jdbc:mysql://localhost:3306/pro_rest";
        String username = "root";
        String password = ""; // Asegúrate de usar la contraseña correcta

        String sql = "INSERT INTO platos (nombre_plato, id_categoria_fk, descripcion_plato, precio_plato ) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plato.getNombrePlato());
            stmt.setInt(2, plato.getIdCategoria());
            stmt.setString(3, plato.getDescripcionPlato());
            stmt.setDouble(4, plato.getPrecioPlato());
            
            stmt.executeUpdate();
            System.out.println("Plato guardado exitosamente en la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

