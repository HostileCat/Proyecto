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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Categoria;
import model.CategoriaDAO;
import model.Platos;
import model.PlatosDAO;

/**
 *
 * @author Propietario
 */
@WebServlet("/administracionPlato")
@MultipartConfig
public class AdministracionPlatos extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
       String idPlato = request.getParameter("idPlato");
       String nombrePlato = request.getParameter("nombrePlato");
       String categoriaPlato = request.getParameter("categoriaPlato");
       String descripcionPlato = request.getParameter("descripcionPlato");
       String precioPlato = request.getParameter("precioPlato");
       
       
       
       
       String accion = request.getParameter("accion");
       
        switch (accion) {
            case "agregarSubmit":
                {
                    String contextPath = getServletContext().getRealPath("/");
                    String alteredFilePath = contextPath.replace("\\target\\proRest-1.0-SNAPSHOT\\", "\\src\\main\\webapp");
                    String uploadFilePath = alteredFilePath + File.separator + UPLOAD_DIR;

                     File uploadDir = new File(uploadFilePath);
                     if (!uploadDir.exists()) {
                         uploadDir.mkdirs();
                     }

                     Part filePart = request.getPart("imagenPlato");
                     String fileName = filePart.getSubmittedFileName();
                     String filePath = uploadFilePath + File.separator + fileName;
                     filePart.write(filePath);
                    
                    Platos plato = new Platos();
                    plato.setNombrePlato(nombrePlato);
                    plato.setIdCategoria(Integer.parseInt(categoriaPlato));
                    plato.setDescripcionPlato(descripcionPlato);
                    plato.setPrecioPlato(Integer.parseInt(precioPlato));
                    plato.setImagenPlato(fileName);
                    
                    PlatosDAO platoDAO = new PlatosDAO();
                    boolean accionExitosa = platoDAO.guardarPlato(plato);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=platos");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "editarSubmit":
                {
                    String contextPath = getServletContext().getRealPath("/");
                    String alteredFilePath = contextPath.replace("\\target\\proRest-1.0-SNAPSHOT\\", "\\src\\main\\webapp");
                    String uploadFilePath = alteredFilePath + File.separator + UPLOAD_DIR;

                     File uploadDir = new File(uploadFilePath);
                     if (!uploadDir.exists()) {
                         uploadDir.mkdirs();
                     }

                     Part filePart = request.getPart("imagenPlato");
                     String fileName = filePart.getSubmittedFileName();
                     String filePath = uploadFilePath + File.separator + fileName;
                     filePart.write(filePath);
                    
                    Platos plato = new Platos();
                    plato.setId(Integer.parseInt(idPlato));
                    plato.setNombrePlato(nombrePlato);
                    plato.setIdCategoria(Integer.parseInt(categoriaPlato));
                    plato.setDescripcionPlato(descripcionPlato);
                    plato.setPrecioPlato(Integer.parseInt(precioPlato));
                    plato.setImagenPlato(fileName);
                    
                    PlatosDAO platoDAO = new PlatosDAO();
                    boolean accionExitosa = platoDAO.actualizarPlato(plato);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=plato");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "eliminar":
                {
                    
                    
                    Platos plato = new Platos();
                    plato.setId(Integer.parseInt(idPlato));
                    
                    
                    PlatosDAO platoDAO = new PlatosDAO();
                    boolean accionExitosa = platoDAO.eliminarPlato(plato);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=platos");
                    } else {
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
        String accion = request.getParameter("accion");
        

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();
        
        String opciones = "";
        
        switch (accion){
            case "agregar":
                
                if (categorias != null) {
                    for (model.Categoria categoria : categorias) {
                        opciones +="<option value='" + categoria.getId() + "'>" + categoria.getNombreCategoria() + "</option>";
                    }
                    request.setAttribute("opciones", opciones);
                }
                request.getRequestDispatcher("administracion/agregarPlatos.jsp").forward(request, response);
                break;
            case "editar":
                
                if (categorias != null) {
                    for (model.Categoria categoria : categorias) {
                        opciones +="<option value='" + categoria.getId() + "'>" + categoria.getNombreCategoria() + "</option>";
                    }
                    request.setAttribute("opciones", opciones);
                }
                
                String idPlato = request.getParameter("idPlato");
                PlatosDAO platosDAO = new PlatosDAO();
                List<Platos> platos = platosDAO.todosLosPlatos();
                
                for(Platos plato: platos){
                    if(plato.getId() == Integer.parseInt(idPlato)){
                        String nombrePlato = plato.getNombrePlato();
                        String descripcionPlato = plato.getDescripcionPlato();
                        int precioPlato = plato.getPrecioPlato();
                        String imagenPlato = plato.getImagenPlato();
                        
                        request.setAttribute("nombrePlato", nombrePlato);
                        request.setAttribute("descripcionPlato", descripcionPlato);
                        request.setAttribute("precioPlato", Integer.toString(precioPlato));
                        request.setAttribute("imagenPlato", imagenPlato);
                        request.setAttribute("idPlato", idPlato);
                    }
                }
                
                request.getRequestDispatcher("administracion/editarPlatos.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

}
