/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.categoriaServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import model.categoria.Categoria;
import model.categoria.CategoriaDAO;

@WebServlet("/listarCategoria_editar")
public class ListarCategorias_editar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();
        
        
        
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("inventario/editarCategoria.jsp").forward(request, response);
        

        
    }
    
    
}


