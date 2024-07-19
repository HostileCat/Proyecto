/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.categoriaServlet;

import controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.categoria.Categoria;
import model.categoria.CategoriaDAO;


@WebServlet("/eliminarCategoria")
public class EliminarCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("categoryId");
        
        if (categoryId != null && !categoryId.isEmpty()) {
            int id = Integer.parseInt(categoryId);
            Categoria categoria = new Categoria();
            categoria.setId(id);
            
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean accionExitosa = categoriaDAO.eliminarCategoria(categoria);

            // Redireccionar a una página de confirmación o mostrar un mensaje de error
            if (accionExitosa) {
                response.sendRedirect("listarCategoria_eliminar");
            } else {
                 response.sendRedirect("../error.jsp");
            }
            
        }


    }
}
