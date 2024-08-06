package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.time.LocalDateTime;
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
 * Servlet para la administración de pedidos.
 */
@WebServlet("/administracionPedidos")
public class AdministracionPedidos extends HttpServlet {

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
        String accion = request.getParameter("accion");
        
        switch (accion){
            case "registrar":
            {
                // Obtener los datos del pedido del formulario
                String totalStr = request.getParameter("total");
                String platosJson = request.getParameter("platos");
                int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                LocalDateTime fechaHoraActual = LocalDateTime.now();

                // Convertir el JSON de platos a una lista de objetos Plato
                Gson gson = new Gson();
                java.lang.reflect.Type listType = new TypeToken<List<PedidoPlato>>() {}.getType();
                List<PedidoPlato> platos = gson.fromJson(platosJson, listType);

                // Convertir el total a un valor entero
                int total = Integer.parseInt(totalStr);

                Pedido pedido = new Pedido();
                pedido.setIdEmpleado(idEmpleado);
                pedido.setFecha(fechaHoraActual);
                pedido.setTotal(total);
                pedido.setPlatos(platos);

                PedidoDAO pedidoDAO = new PedidoDAO();
                boolean accionExitosa = pedidoDAO.guardarPedido(pedido);

                if (accionExitosa) {
                    response.sendRedirect("paginaRegistrarPedido");
                } 
            }
            
        }
        
        
    }
}
