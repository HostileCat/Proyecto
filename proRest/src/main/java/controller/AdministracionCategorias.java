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
 *
 * @author Propietario
 */
@WebServlet("/administracionCategoria")
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
       String nombreCategoria = request.getParameter("nombreCategoria");
       String accion = request.getParameter("accion");
       
       if(accion.equals("agregar")){
           Categoria categoria = new Categoria();
           categoria.setNombreCategoria(nombreCategoria);
           
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            boolean accionExitosa = categoriaDAO.agregarCategoria(categoria);

            // Redireccionar a una página de confirmación o mostrar un mensaje de error
            if (accionExitosa) {
                response.sendRedirect("paginaCategorias?opcion=categoria");
            } else {
                 response.sendRedirect("../error.jsp");
            }
       } else if(accion.equals("editar")) {
           
           Categoria categoria = new Categoria();
          
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }

}
