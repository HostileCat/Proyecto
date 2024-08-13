<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Carta</title>
    <link rel="stylesheet" href="/proRest/css/carta.css"> <!-- Ajusta la ruta según tu estructura -->
</head>
<body>
    
    <%
        String headerFile;
        if (session.getAttribute("usuario") != null) {
            // Usuario ha iniciado sesión
            headerFile = "componentes/header.jsp"; // Asegúrate de que la ruta sea correcta
        } else {
            // Usuario no ha iniciado sesión
            headerFile = "componentes/headerUnlogged.jsp"; // Asegúrate de que la ruta sea correcta
        }
    %>

    <jsp:include page="<%= headerFile %>" />
    
    
    
    <main class="main">
        <h1 class="main__title">Carta</h1>
        
        <div class="grid__container">
            <!-- Contenedor de categorías y platos -->
            <div class="category__container">
                <%
                    String container = (String) request.getAttribute("container");
                    
                    if(container != null){
                        out.print(container);
                    }
                %>
            </div>
        </div>

    </main>
                        

    <script src="js/script.js" type="module"></script>
</body>
</html>
