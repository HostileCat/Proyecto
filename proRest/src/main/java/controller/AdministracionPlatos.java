
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
 * Servlet para la administración de platos.
 */
@WebServlet("/administracionPlato") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
@MultipartConfig
public class AdministracionPlatos extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads"; // se crea el nombre de la carpeta
    
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
       String idPlato = request.getParameter("idPlato");
       String nombrePlato = request.getParameter("nombrePlato");
       String categoriaPlato = request.getParameter("categoriaPlato");
       String descripcionPlato = request.getParameter("descripcionPlato");
       String precioPlato = request.getParameter("precioPlato");
       String estadoPlato = request.getParameter("estado");
       
       
       
       String accion = request.getParameter("accion");
       
        switch (accion) {
            case "agregarSubmit":
                {
                    // Obtiene la ruta absoluta del contexto del servlet. La ruta apunta al directorio raíz de la aplicación web.
                    String contextPath = getServletContext().getRealPath("/");
                    // Se intercambia una parte de la ruta por la ruta deseada
                    String alteredFilePath = contextPath.replace("\\target\\proRest-1.0-SNAPSHOT\\", "\\src\\main\\webapp"); 
                    // Se concatena el nombre del archivo con la ruta
                    String uploadFilePath = alteredFilePath + File.separator + UPLOAD_DIR; 
                    
                    // Crea un objeto `File` que representa el directorio de destino para las cargas de archivos.
                     File uploadDir = new File(uploadFilePath);
                     
                     // Verifica si el directorio de destino no existe; si no existe, lo crea.
                     if (!uploadDir.exists()) {
                         uploadDir.mkdirs();
                     }
                     
                     // Obtiene el contenido del archivo enviado en el formulario.
                     Part filePart = request.getPart("imagenPlato"); 
                     // Obtiene el nombre original del archivo cargado desde el campo del formulario.
                     String fileName = filePart.getSubmittedFileName(); 
                     // Construye la ruta completa para guardar el archivo concatenando la ruta del directorio de carga con el nombre del archivo.
                     String filePath = uploadFilePath + File.separator + fileName; 
                     // Escribe el contenido del archivo en la ruta especificada en el sistema de archivos.
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
                        response.sendRedirect("paginaPlatos?opcion=plato");
                    } else {
                        response.sendRedirect("../error.jsp");
                    }       
                    break;
                }
            case "editarSubmit":
                {
                    // Obtiene la ruta absoluta del contexto del servlet. La ruta apunta al directorio raíz de la aplicación web.
                    String contextPath = getServletContext().getRealPath("/");
                    // Se intercambia una parte de la ruta por la ruta deseada
                    String alteredFilePath = contextPath.replace("\\target\\proRest-1.0-SNAPSHOT\\", "\\src\\main\\webapp"); 
                    // Se concatena el nombre del archivo con la ruta
                    String uploadFilePath = alteredFilePath + File.separator + UPLOAD_DIR; 
                    
                    // Crea un objeto `File` que representa el directorio de destino para las cargas de archivos.
                     File uploadDir = new File(uploadFilePath);
                     
                     // Verifica si el directorio de destino no existe; si no existe, lo crea.
                     if (!uploadDir.exists()) {
                         uploadDir.mkdirs();
                     }
                     
                     // Obtiene el contenido del archivo enviado en el formulario.
                     Part filePart = request.getPart("imagenPlato"); 
                     // Obtiene el nombre original del archivo cargado desde el campo del formulario.
                     String fileName = filePart.getSubmittedFileName(); 
                     // Construye la ruta completa para guardar el archivo concatenando la ruta del directorio de carga con el nombre del archivo.
                     String filePath = uploadFilePath + File.separator + fileName; 
                     // Escribe el contenido del archivo en la ruta especificada en el sistema de archivos.
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
            case "estado":
                {
                    Platos plato = new Platos();
                    
                    PlatosDAO platoDAO = new PlatosDAO();
                    plato.setId(Integer.parseInt(idPlato));
                    plato.setEstado(Boolean.parseBoolean(estadoPlato));

                    boolean accionExitosa = platoDAO.cambiarEstadoPlato(plato);
                    // Redireccionar a una página de confirmación o mostrar un mensaje de error
                    if (accionExitosa) {
                        response.sendRedirect("paginaPlatos?opcion=plato");
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
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.todasLasCategorias();
        
        String opciones = "";
        
        switch (accion){
            case "agregar":
                
                if (categorias != null) {
                    for (Categoria categoria : categorias) {
                        opciones +="<option value='" + categoria.getId() + "'>" + categoria.getNombreCategoria() + "</option>";
                    }
                    request.setAttribute("opciones", opciones);
                }
                request.getRequestDispatcher("administracion/agregarPlatos.jsp").forward(request, response);
                break;
            case "editar":
                String idCategoria = request.getParameter("idCategoria");
                int idCategoriaInt = Integer.parseInt(idCategoria);
                if (categorias != null) {
                    for (Categoria categoria : categorias) {
                        opciones +="<option value='" + categoria.getId() + "' "+ (categoria.getId() == idCategoriaInt? "selected": "") +">" + categoria.getNombreCategoria() + "</option>";
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

