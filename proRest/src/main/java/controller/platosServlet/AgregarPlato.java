/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.platosServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Platos;
import model.PlatosDAO;



@WebServlet("/guardarPlato")
@MultipartConfig
public class AgregarPlato extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombrePlato = request.getParameter("nombrePlato");
        int categoriaPlato = Integer.parseInt(request.getParameter("categoriaPlato"));
        String descripcionPlato = request.getParameter("descripcionPlato");
        int precioPlato = Integer.parseInt(request.getParameter("precioPlato"));
        
        String contextPath = getServletContext().getRealPath("/");
       String alteredFilePath = contextPath.replace("target/proRest-1.0-SNAPSHOT", "src/main/webapp");
       String uploadFilePath = alteredFilePath + File.separator + UPLOAD_DIR;
        
        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        Part filePart = request.getPart("imagenPlato");
        String fileName = filePart.getSubmittedFileName();
        String filePath = uploadFilePath + File.separator + fileName;
        filePart.write(filePath);

        // Crear objeto Plato
        Platos plato = new Platos();
        plato.setNombrePlato(nombrePlato);
        plato.setIdCategoria(categoriaPlato);
        plato.setDescripcionPlato(descripcionPlato);
        plato.setPrecioPlato(precioPlato);
        plato.setImagenPlato(fileName);

        // Guardar en la base de datos
        PlatosDAO platoDAO = new PlatosDAO();
        platoDAO.guardarPlato(plato);

        // Redirigir a la lista de platos o a una página de confirmación
        response.sendRedirect("inventario/agregarPlato.jsp");
    }
}