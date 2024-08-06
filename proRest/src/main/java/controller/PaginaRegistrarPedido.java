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
 * Servlet para la insertar los platos habilitados organizados por categoria.
 */
@WebServlet("/paginaRegistrarPedido")
public class PaginaRegistrarPedido extends HttpServlet {

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
        String lista = "";
        String container = "";
        
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        PlatosDAO platosDAO = new PlatosDAO();
        
        List<Categoria> categorias = categoriaDAO.obtenerCategoriasRelacionadas();
        
        lista += "<ul class='category__list'>";
        for (Categoria categoria : categorias) {
            lista += "<li><a href='#categoria" + categoria.getId() + "'>" + categoria.getNombreCategoria()+ "</a></li>";
        }
        lista += "</ul>";
        
        
        for (Categoria categoria : categorias) {
            container += "<div class='categoria' id='categoria" + categoria.getId() + "'>"
                    + "<h3>" + categoria.getNombreCategoria()+ "</h3>"
                    + "<div class='grid'>"
                    + "<h3 class='grid__title'>Plato</h3>"
                    + "<h3 class='grid__title'>Precio</h3>"
                    + "<h3 class='grid__title'>Acción</h3>";
            
            List<Platos> platos = platosDAO.obtenerPlatosPorCategoria(); // Método para obtener los platos por categoría
            
            for (Platos plato : platos) {
                
                if (plato.getIdCategoria() == categoria.getId()){
                   container += "<p class='grid__item'>" + plato.getNombrePlato()+ "</p>"
                        + "<p class='grid__item'>$" + plato.getPrecioPlato()+ "</p>"
                        + "<button class='agregar__plato' data-plato='" + plato.getNombrePlato()+ "' data-precio='" + plato.getPrecioPlato()+ "' data-id='" + plato.getId()+ "'>Agregar</button>";
                }
            }
            
            container += "</div>"
                    + "</div>";
        }
        
        
        request.setAttribute("lista", lista);
        request.setAttribute("container", container);
        request.getRequestDispatcher("pedidos/hacerPedido.jsp").forward(request, response);
    }    
}
