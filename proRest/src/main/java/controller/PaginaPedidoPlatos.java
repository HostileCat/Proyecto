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
import model.Pedido;
import model.PedidoDAO;
import model.PedidoPlato;

/**
 * Servlet para la insertar los detalles del pedido según el pedido seleccionado.
 */
@WebServlet("/paginaPedidoPlatos") // Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
public class PaginaPedidoPlatos extends HttpServlet {

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
        String idPedido = request.getParameter("idPedido");
        String totalPedido = request.getParameter("totalPedido");
        String nombreEmpleado = request.getParameter("nombreEmpleado");
        String fechaPedido = request.getParameter("fechaPedido");
        
        String fila = "";
        String total = "";
        String info = "";
        
        PedidoDAO pedidoDAO = new PedidoDAO(); 
        
        Pedido pedido = new Pedido();
        pedido.setIdPedido(Integer.parseInt(idPedido));
        
        List<PedidoPlato> platos = pedidoDAO.obtenerPlatosPorPedido(pedido);
        
        
        info += "<div class='invoice__info'>" +
"                <p><strong>Fecha: </strong>"+ fechaPedido +"</p>" +
"                <p><strong>Atendido por: </strong>"+ nombreEmpleado +"</p>" +
"            </div>";
        
        for (PedidoPlato plato : platos) {

            fila += "<p class='grid__item'>" + plato.getNombre()+ "</p>" +
                    "<p class='grid__item grid__item--center'>" + plato.getPrecio()+ "</p>" +
                    "<p class='grid__item grid__item--center'>" + plato.getCantidad()+ "</p>" +
                    "<p class='grid__item'>" + plato.getDetalle() + "</p>" +
                    "<p class='grid__item'>" + plato.getPrecio() * plato.getCantidad()+ "</p>";
            
            
        }
        
        total += "<h3 class='total__title'>Total del Pedido: "+ totalPedido +"</h3>";
        
        
        request.setAttribute("info", info);
        request.setAttribute("fila", fila);
        request.setAttribute("total", total);
        
        request.getRequestDispatcher("pedidos/pedidoPlatos.jsp").forward(request, response);
    }
}
