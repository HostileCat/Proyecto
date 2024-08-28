/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;
import model.Platos;
import model.PlatosDAO;

/**
 * Servlet para la insertar platos habilitados a la carta.
 */
@WebServlet("/paginaCarta") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
public class PaginaCarta extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String container = "";
        
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        PlatosDAO platosDAO = new PlatosDAO();
        
        List<Categoria> categorias = categoriaDAO.obtenerCategoriasRelacionadas();
        
        
        for (Categoria categoria : categorias) {
            container += "<div class='category'>"
                    + "<h3 class='category__title'>" + categoria.getNombreCategoria()+ "</h3>"
                    + "<div class='grid'>";

            List<Platos> platos = platosDAO.obtenerPlatosPorCategoria(); // Método para obtener los platos por categoría
            
            
            
            for (Platos plato : platos) {
                
                if (plato.getIdCategoria() == categoria.getId()){
                    container += "<div class='view__card'>" +
                                "<div class='view__img' id='vistaImg' style=\"background-image: url('/proRest/uploads/"+ plato.getImagenPlato() +"')\"></div>" +
                                "<h2 class='view__dishName' id='vistaNombre'>"+ plato.getNombrePlato() +"</h2>" +
                                "<p class='view__dishDescription' id='vistaDescripcion'>"+ plato.getDescripcionPlato() +"</p>" +
                                "<h2 class='view__dishCost' id='vistaPrecio'>$"+ plato.getPrecioPlato() +"</h2>" +
                                "</div>";
                }
            }
            container += "</div>"
                    + "</div>";
        }
        
        request.setAttribute("container", container);
        request.getRequestDispatcher("verCarta.jsp").forward(request, response);
    }
}
