/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import model.PedidoDAO;

/**
 * Servlet para la insertar categorias a la pagina de administración.
 */
@WebServlet("/paginaPedidos")
public class PaginaPedidos extends HttpServlet {

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
        String fila = "";
        
        PedidoDAO pedidoDAO = new PedidoDAO(); 
        
        List<Pedido> pedidos = pedidoDAO.todosLosPedidos();
        
        
        for (Pedido pedido : pedidos) {
            
            LocalDateTime fecha = pedido.getFecha(); 
            
            // Crear un formatter con un formato personalizado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 

            // Parsear la cadena a un objeto LocalDateTime
            String fechaFormateada = fecha.format(formatter);
            
            fila += "<p class='grid__item'>" + pedido.getIdPedido()+ "</p>" +
                    "<p class='grid__item'>" + fechaFormateada + "</p>" +
                    "<p class='grid__item'>" + pedido.getNombreEmpleado()+ "</p>" +
                    "<p class='grid__item'>" + pedido.getTotal()+ "</p>"
                    + "<div class='grid__item actionButtons'>" +
                    "<form action='/proRest/paginaPedidoPlatos' method='get'>" +
                    "<input type='hidden' name='idPedido' value='" + pedido.getIdPedido() + "'>" +
                    "<input type='hidden' name='nombreEmpleado' value='" + pedido.getNombreEmpleado()+ "'>" +
                    "<input type='hidden' name='fechaPedido' value='" + fechaFormateada+ "'>" +
                    "<input type='hidden' name='totalPedido' value='" + pedido.getTotal() + "'>" +
                    "<button type='submit' class='view__button'>Ver</button>" +
                    "</form>" +
                    "</div>";
            
        }
        
        
        
        request.setAttribute("fila", fila);
        
        request.getRequestDispatcher("pedidos/historialPedido.jsp").forward(request, response);
    }

}
