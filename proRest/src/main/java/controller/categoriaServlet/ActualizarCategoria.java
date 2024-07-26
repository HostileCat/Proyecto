/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.categoriaServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;


/**
 *
 * @author Propietario
 */
@WebServlet("/agregarCategoria")
public class ActualizarCategoria extends HttpServlet {
    

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       String nombreCategoria = request.getParameter("nombreCategoria");
       String idCategoriaStr = request.getParameter("categoryId");
       
       if(idCategoriaStr == null){
           int idCategoria = 0;
           Categoria categoria = new Categoria();
           categoria.setId(idCategoria);
           categoria.setNombreCategoria(nombreCategoria);
           
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean accionExitosa = categoriaDAO.agregarCategoria(categoria);

            // Redireccionar a una página de confirmación o mostrar un mensaje de error
            if (accionExitosa) {
                response.sendRedirect("inventario/agregarCategoria.jsp");
            } else {
                 response.sendRedirect("../error.jsp");
            }
       } else {
           int idCategoria = Integer.parseInt(idCategoriaStr);
           Categoria categoria = new Categoria();
           categoria.setId(idCategoria);
           categoria.setNombreCategoria(nombreCategoria);
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean accionExitosa = categoriaDAO.actualizarNombreCategoria(categoria);

            // Redireccionar a una página de confirmación o mostrar un mensaje de error
            if (accionExitosa) {
                response.sendRedirect("listarCategoria_editar");
            } else {
                 response.sendRedirect("../error.jsp");
            }
        }
       
       
    }
    
}
