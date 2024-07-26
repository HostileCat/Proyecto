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


@WebServlet("/paginaCategorias")
public class PaginaCategorias extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        String titulo = "";
        String fila = "";
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();
        
        PlatosDAO platosDAO = new PlatosDAO();
        List<Platos> platos = platosDAO.todosLosPlatos();
        
        switch(opcion){
            case "categoria":
                titulo = "<h2 class='section__title'>Administrar Categorias</h2>";
                for (Categoria categoria : categorias){
                    fila = "<p class='grid__item'>"+ categoria.getId() +"</p>" +
                               "<p class='grid__item'>"+ categoria.getNombreCategoria()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionCategoria' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ categoria.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ categoria.getNombreCategoria() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionCategoria' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idUsuario' value='"+ categoria.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
                               "</form>" +
                               "</div>";
                }
                
                
                break;
            case "plato":
                titulo = "<h2 class='section__title'>Administrar Platos</h2>";
                for (Categoria categoria : categorias){
                    fila = "<p class='grid__item'>"+ categoria.getId() +"</p>" +
                               "<p class='grid__item'>"+ categoria.getNombreCategoria()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionCategoria' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+ categoria.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ categoria.getNombreCategoria() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionCategoria' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idUsuario' value='"+ categoria.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
                               "</form>" +
                               "</div>";
                }
                
                
                break;
            default:
                break;
        }
        
        request.setAttribute("fila", fila);
        request.getRequestDispatcher("administracion/inventarioDefault.jsp").forward(request, response);
    }

}
