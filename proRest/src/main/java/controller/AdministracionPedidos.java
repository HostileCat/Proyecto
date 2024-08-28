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
@WebServlet("/administracionPedidos")// Define la URL en la que el servlet estará disponible.

// extends HttpServlet en Java se utiliza para definir que la clase es un servlet
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
                String platosJson = request.getParameter("platos"); // se obtiene un JSON
                int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                LocalDateTime fechaHoraActual = LocalDateTime.now(); // se crea la fecha y hora actual

                // Convertir el JSON de platos a una lista de objetos Plato
                Gson gson = new Gson();
                // permite especificar a que tipo de datos se desea convertir.
                java.lang.reflect.Type listType = new TypeToken<List<PedidoPlato>>() {}.getType(); 
                // el json se convierte a una lista de objetos de la clase PedidoPlato
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
