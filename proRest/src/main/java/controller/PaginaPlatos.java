/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
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
 * Servlet para la insertar categorias a la pagina de administración.
 */
@WebServlet("/paginaPlatos")
public class PaginaPlatos extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opcion = request.getParameter("opcion");
        
        switch(opcion){
            case "categoriaSubmit":
                response.sendRedirect("paginaPlatos?opcion=categoria");
            case "platoSubmit":
                response.sendRedirect("paginaPlatos?opcion=plato");    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
                botonAgregar = "<a href='/proRest/administracionCategoria?accion=agregar' id='addUserBtn' class='add__button'>+</a>"
                        + "<p class='add__text'>Añadir Categoria</p>";
                grid = "<h2 class='section__title'>Administrar Categorias</h2>"
                        + "<div class='grid__containerCategory' id='userGridContainer'>"
                        + "<h3 class='grid__title'>Nombre</h3>" +
                            "<h3 class='grid__title'>Acciones</h3>";
                for (Categoria categoria : categorias){
                    tabla +="<p class='grid__item'>"+ categoria.getNombreCategoria()+"</p>" +
                               "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionCategoria' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idCategoria' value='"+ categoria.getId() +"'>" +
                               "<input type='hidden' name='nombreCategoria' value='"+ categoria.getNombreCategoria() +"'>" +
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionCategoria' id='formEliminar' method='post'>" +
                               "<input type='hidden' name='accion' value='eliminar'>" +
                                "<input type='hidden' name='idCategoria' value='"+ categoria.getId() +"'>" +
                               "<button type='submit' class='delete__button'>Eliminar</button>" +
                               "</form>" +
                               "</div>";
                            
                }
                
                
                break;
            case "plato":
                botonAgregar = "<a href='/proRest/administracionPlato?accion=agregar' id='addUserBtn' class='add__button'>+</a>"
                        + "<p class='add__text'>Añadir Plato</p>";
                grid = "<h2 class='section__title'>Administrar Platos</h2>"
                        + "<div class='grid__containerDish' id='userGridContainer'>"
                        + "<h3 class='grid__title'>Nombre</h3>" +
                            "<h3 class='grid__title'>Descripcion</h3>" + 
                            "<h3 class='grid__title'>Precio</h3>" +
                            "<h3 class='grid__title'>Ruta Imagen</h3>" +
                            "<h3 class='grid__title'>Categoria</h3>" + 
                            "<h3 class='grid__title'>Estado</h3>" +
                            "<h3 class='grid__title'>Acciones</h3>";
                
                
                
                
                for (Platos plato : platos){
                    tabla +="<p class='grid__item'>"+ plato.getNombrePlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getDescripcionPlato()+"</p>" +
                            "<p class='grid__item'>"+ plato.getPrecioPlato()+"</p>" +
                            "<p class='grid__item'>" + plato.getImagenPlato() +"</p>" +
                            "<p class='grid__item'>"+ plato.getNombreCategoria()+"</p>" +
                            "<p class='grid__item'>"+ (plato.isEstado()? "Habilitado" : "Inhabilitado")+"</p>" +                               
                                "<div class='grid__item actionButtons'>" +
                               "<form action='/proRest/administracionPlato' method='get'>" +
                               "<input type='hidden' name='accion' value='editar'>" +
                               "<input type='hidden' name='idPlato' value='"+  plato.getId() +"'>" +
                            "<input type='hidden' name='idCategoria' value='"+ plato.getIdCategoria() +"'>"+
                                "<button type='submit' class='edit__button'>Editar</button>" +
                               "</form>" +
                               "<form action='/proRest/administracionPlato' method='post'>" +
                               "<input type='hidden' name='accion' value='estado'>" +
                                "<input type='hidden' name='idPlato' value='"+ plato.getId() +"'>" 
                                + "<input type='hidden' name='estado' value='"+ !plato.isEstado() +"'>" +
                                "<button type='submit' class='status__button "+ (!plato.isEstado()? "negative" : "") +"'>" + (plato.isEstado()? "Inhabilitar" : "Habilitar") + "</button>" +
                               "</form>"
                            + "</div>";
                }
                
                
                break;
            default:
                break;
        }
        
        request.setAttribute("tabla", tabla);
        request.setAttribute("botonAgregar", botonAgregar);
        request.setAttribute("grid", grid);
        request.getRequestDispatcher("administracion/administracionPlatos.jsp").forward(request, response);
    }

}
