/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.platosServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.categoria.Categoria;
import model.categoria.CategoriaDAO;
import model.platos.Platos;
import model.platos.PlatosDAO;


@WebServlet("/listarPlatos_eliminar")
public class ListarPlatos_eliminar extends HttpServlet {

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
        // Llamar al DAO para obtener la lista de platos y categorías
        PlatosDAO platoDAO = new PlatosDAO();
        List<Platos> platos = platoDAO.obtenerTodosLosPlatos();

        // Llamar al DAO para obtener la lista de categorías (opcional)
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();

        // Guardar los resultados en el request para ser utilizados en el JSP
        request.setAttribute("platos", platos);
        request.setAttribute("categorias", categorias);

        // Redirigir al JSP que mostrará los platos y categorías
        request.getRequestDispatcher("inventario/eliminarPlato.jsp").forward(request, response);
    }
}
