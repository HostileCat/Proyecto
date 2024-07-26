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
        String botonAgregar = "";
        String grid = "";
        String tabla = "";
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();
        
        PlatosDAO platosDAO = new PlatosDAO();
        List<Platos> platos = platosDAO.todosLosPlatos();
        
        switch(opcion){
            case "categoria":
                botonAgregar = "<a href='/proRest/administracionCategoria' id='addUserBtn' class='add__button'>+</a>"
                        + "<p class='add__text'>Añadir Categoria</p>";
                grid = "<h2 class='section__title'>Administrar Categorias</h2>"
                        + "<div class='grid__containerCategory' id='userGridContainer'>"
                        + "<h3 class='grid__title'>ID</h3>" +
                            "<h3 class='grid__title'>Nombre</h3>" +
                            "<h3 class='grid__title'>Acciones</h3>";
                for (Categoria categoria : categorias){
                    tabla +="<p class='grid__item'>"+ categoria.getId() +"</p>" +
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
                botonAgregar = "<a href='/proRest/administracionPlato?accion=agregar' id='addUserBtn' class='add__button'>+</a>"
                        + "<p class='add__text'>Añadir Plato</p>";
                grid = "<div class='grid__containerDish' id='userGridContainer'>"
                        + "<h2 class='section__title'>Administrar Platos</h2>";
                for (Platos plato : platos){
                    tabla +="<h3 class='grid__title'>ID</h3>" +
                            "<h3 class='grid__title'>Nombre</h3>" +
                            "<h3 class='grid__title'>Descripcion</h3>" + 
                            "<h3 class='grid__title'>Precio</h3>" +
                            "<h3 class='grid__title'>Ruta Imagen</h3>" +
                            "<h3 class='grid__title'>Categoria</h3>" + 
                            "<h3 class='grid__title'>Acciones</h3>" + 
                            "<p class='grid__item'>"+ plato.getId() +"</p>" +
                               "<p class='grid__item'>"+ plato.getNombrePlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getDescripcionPlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getPrecioPlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getPrecioPlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getNombreCategoria()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionCategoria' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idUsuario' value='"+  plato.getId() +"'>" +
                               "<input type='hidden' name='nombreUsuario' value='"+ plato.getDescripcionPlato() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionCategoria' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idUsuario' value='"+ plato.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
                               "</form>";
                }
                
                
                break;
            default:
                break;
        }
        
        request.setAttribute("tabla", tabla);
        request.setAttribute("botonAgregar", botonAgregar);
        request.setAttribute("grid", grid);
        request.getRequestDispatcher("administracion/inventarioDefault.jsp").forward(request, response);
    }

}
