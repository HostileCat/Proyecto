/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;

/**
 * Servlet para la administración de categorías de platos.
 */
@WebServlet("/administracionCategoria") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
public class AdministracionCategorias extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       request.setCharacterEncoding("UTF-8");
        String nombreCategoria = request.getParameter("nombreCategoria");
       String accion = request.getParameter("accion");
       
      
       
        switch (accion) {
            case "agregarSubmit":
                {
                    Categoria categoria = new Categoria();
                    categoria.setNombreCategoria(nombreCategoria);
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    boolean accionExitosa = categoriaDAO.agregarCategoria(categoria);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=categoria");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "editarSubmit":
                {
                    String idCategoria = request.getParameter("idCategoria");
                    Categoria categoria = new Categoria();
                    categoria.setId(Integer.parseInt(idCategoria));
                    categoria.setNombreCategoria(nombreCategoria);
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    boolean accionExitosa = categoriaDAO.actualizarNombreCategoria(categoria);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=categoria");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "eliminar":
                {
                    
                    String idCategoria = request.getParameter("idCategoria");
                    Categoria categoria = new Categoria();
                    categoria.setId(Integer.parseInt(idCategoria));
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    boolean accionExitosa = categoriaDAO.eliminarCategoria(categoria);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=categoria");
                    }  else {
                        response.sendRedirect("../error.jsp");
                    }   
                    break;
                }
            default:
                break;
        }
       
       
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        switch (accion){
            case "agregar":
                request.getRequestDispatcher("administracion/agregarCategoria.jsp").forward(request, response);
                break;
            case "editar":
                String idCategoria = request.getParameter("idCategoria");
                request.setAttribute("idCategoria", idCategoria);
                request.getRequestDispatcher("administracion/editarCategoria.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

}
