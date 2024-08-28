/**
 * Anotaciones de Servlets:
 * 
 * @Override
 * Indica que el método está sobrescribiendo un método de la clase base HttpServlet.
 * 
 * @WebServlet
 * Define la URL en la que el servlet estará disponible.
 * 
 * @MultipartConfig
 * Se utiliza para manejar datos de formularios que contienen archivos adjuntos
 * 
 * Excepciones de Servlets:
 * 
 * ServletException
 * Esta excepción puede ser lanzada si hay un problema en el procesamiento 
 * de la solicitud dentro del servlet.
 * 
 * IOException: 
 * Esta excepción puede ser lanzada en caso de errores de entrada/salida, 
 * como problemas al leer o escribir datos en el flujo de entrada o salida.
 * 
 * 
 * request:
 * 
 * request.setCharacterEncoding("UTF-8");
 * Este método establece la codificación de caracteres UTF-8 que permite la
 * cualquier carácter en el conjunto de caracteres Unicode.
 * 
 * request.getParameter
 * Recupera el valor de un parámetro enviado en una solicitud HTTP, ya sea a 
 * través de un formulario HTML (método GET o POST) o mediante otros mecanismos 
 * como la consulta de la URL.
 * 
 * request.setAttribute
 * Asocia un valor con un nombre específico en el contexto de la solicitud. 
 * Este valor se almacena en el objeto HttpServletRequest y puede ser recuperado 
 * más adelante.
 * 
 * request.getRequestDispatcher
 * obtiene un RequestDispatcher que permite despachar o redirigir la solicitud 
 * al recurso especificado.
 * 
 * forward(request, response)
 * Pasa el control al recurso especificado en el objeto RequestDispatcher. La 
 * solicitud original y la respuesta son manejadas por este recurso. La respuesta 
 * generada por el recurso es la que se envía de vuelta al cliente.
 * 
 * 
 * response:
 * 
 * Redirige al cliente a una URL diferente
 * 
 */
